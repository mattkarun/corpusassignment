import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Graph 
{

	private final Map<Character, List<Vertex>> vertices;

	public Graph() 
	{
		this.vertices = new LinkedHashMap<Character, List<Vertex>>();
	}

	public void addVertex(Character character, List<Vertex> vertex) 
	{
		this.vertices.put(character, vertex);
	}

	public List<Character> getShortestPath(Character start, Character finish) 
	{
		
		Map<Character, Integer> distances = new LinkedHashMap<Character, Integer>();
		PriorityQueue<Vertex> nodes = new PriorityQueue<Vertex>();
		Map<Character, Vertex> previous = new LinkedHashMap<Character, Vertex>();
		List<Character> path = new LinkedList<Character>();

		for (Character vertex : vertices.keySet()) 
		{
			if (vertex == start) 
			{
				distances.put(vertex, 0);
				nodes.add(new Vertex(vertex, 0));
			} 
			else 
			{
				distances.put(vertex, Integer.MAX_VALUE);
				nodes.add(new Vertex(vertex, Integer.MAX_VALUE));
			}
			previous.put(vertex, null);
		}

		while (!nodes.isEmpty()) 
		{
			Vertex node = nodes.poll();
			if (node.getId() == finish) 
			{
				path = new LinkedList<Character>();
				while (previous.get(node.getId()) != null) 
				{
					path.add(node.getId());
					node = previous.get(node.getId());
				}
				return path;
			}

			if (distances.get(node.getId()) == Integer.MAX_VALUE) 
			{
				break;
			}

			for (Vertex neighbor : vertices.get(node.getId())) 
			{
				Integer alt = distances.get(node.getId()) + neighbor.getDistance();
				System.out.println("Alt: " + alt + ", distances.get(neighbor.getId()) " + distances.get(neighbor.getId()));
				if (alt < distances.get(neighbor.getId())) 
				{
					distances.put(neighbor.getId(), alt);
					previous.put(neighbor.getId(), node);

					forloop: for (Vertex n : nodes) 
					{
						if (n.getId() == neighbor.getId()) 
						{
							n.setDistance(alt);
							break forloop;
						}
					}
				}
			}
			System.out.println("distances  " + distances);
			System.out.println("previous  " + previous + "\n\n");
		}
		return new ArrayList<Character>(distances.keySet());
	}
}