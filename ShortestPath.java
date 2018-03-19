import java.util.*;
//import java.lang.*;
//import java.io.*;
 
class ShortestPath
{
	
   int V=9;
    int minDistance(int dist[], Boolean spath[])
    {
        int min = Integer.MAX_VALUE;
		int min_index=-1;
 
        for (int v = 0; v < V; v++)
            if (spath[v] == false && dist[v] < min)
            {
                min = dist[v];
                min_index = v;
            }
 
        return min_index;
    }
 
    
 
    void dijkstra(int graph[][], int src)
    {
 
        Boolean spath[] = new Boolean[V];
		int[] parent=new int[graph.length];
		int dist[] = new int[graph.length];
 		
        for (int i = 0; i < V; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            spath[i] = false;
        }
		
        dist[src] = 0;
		parent[src]=src;
 
        for (int count = 0; count < V-1; count++)
        {
            int u = minDistance(dist, spath);
            spath[u] = true;
 
            for (int v = 0; v < V; v++)
			{
				if (!spath[v] && graph[u][v]!=0 && dist[u] != Integer.MAX_VALUE
                    && dist[u]+graph[u][v] < dist[v])
				{
					dist[v] = dist[u] + graph[u][v];
					parent[v]=u;
					
				}
			}
                    
        }
       System.out.println("distance \t\t\t path");
	   for(int i=0;i<graph.length;i++)
		{
			System.out.print(""+dist[i]+"\t\t\t");
			printparent(i,parent);
			System.out.print(i+" , ");
			System.out.println();
		}
        printSolution(dist);
    }
	
 
	public int findparent(int c,int[] parent)
	{
		return parent[c];
	}
		
	public void printparent(int p,int[] parent)
	{
		if(p==0)
				return;
		else
		{
			int x=findparent(p,parent);
			printparent(x,parent);
			System.out.print(x+" , ");
		}	
	}
    void printSolution(int dist[])
    {
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < V; i++){
            System.out.print(i+"\t"+dist[i]+"\t");
            System.out.println();
        }
    }
    
 
    public static void main (String[] args)
    {							//	 0	1  2  3  4  5  6  7  8
       int graph[][] = new int[][]{	{0, 4, 0, 0, 0, 0, 0, 8, 0}, //0
									{4, 0, 8, 0, 0, 0, 0, 11, 0},//1
									{0, 8, 0, 7, 0, 4, 0, 0, 2},//2
									{0, 0, 7, 0, 9, 14, 0, 0, 0},//3
									{0, 0, 0, 9, 0, 10, 0, 0, 0},//4
									{0, 0, 4,14, 10, 0, 2, 0, 0},//5
									{0, 0, 0, 0, 0,  2, 0, 1, 6},//6
									{8,11, 0, 0, 0,  0, 1, 0, 7},//7
									{0, 0, 2, 0, 0,   0, 6, 7, 0}//8
                                 };
		
        ShortestPath t = new ShortestPath();
        t.dijkstra(graph, 0);
        
		
    }
}
