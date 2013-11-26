class Vertex implements Comparable<Vertex> 
{

	private Character id;
	private Integer distance;

	public Vertex(Character id, Integer distance) 
	{
		super();
		this.id = id;
		this.distance = distance;
	}

	public Character getId() 
	{
		return id;
	}

	public Integer getDistance() 
	{
		return distance;
	}

	public void setId(Character id) 
	{
		this.id = id;
	}

	public void setDistance(Integer distance) 
	{
		this.distance = distance;
	}

	@Override
	public String toString() 
	{
		return "Vertex [id=" + id + ", distance=" + distance + "]";
	}

	@Override
	public int compareTo(Vertex o) 
	{
		return this.distance < o.distance ? -1
				: this.distance == o.distance ? 0 : 1;
	}
}