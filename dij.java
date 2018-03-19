import java.util.*;
class dij{
    int V=9;
    int minDis(int []dist,boolean[] spath){
        int min=Integer.MAX_VALUE;
        int min_index=-1;
        for(int v=0;v<V;v++){
            if(!spath[v] && dist[v]<min){
                min=dist[v];
                min_index=v;
            }
           
        }
         return min_index;
    }
    void dijAlgo(int[][] graph,int src){
        boolean [] spath=new boolean[graph.length];
        int[] dist=new int[graph.length];
        int[] parent=new int[graph.length];
        for(int v=0;v<V;v++){
            dist[v]=Integer.MAX_VALUE;
            spath[v]=false;
        }
        dist[src]=0;
        parent[src]=src;
        for(int count=0;count<V-1;count++){
            int u=minDis(dist,spath);
            spath[u]=true;
            for(int v=0;v<V;v++){
                if(!spath[v] && graph[u][v]!=0 && dist[u]!=Integer.MAX_VALUE && dist[u]+graph[u][v]<dist[v]){
                    dist[v]=dist[u]+graph[u][v];
                    parent[v]=u;
                }
            }
            
            
        }
        for(int i=0;i<V;i++){
            System.out.print(dist[i]+"\t ");
            printParent(i,parent,src);
            System.out.print(i+", ");
            System.out.println();
        }
    }
    void printParent(int p,int[] parent,int src){
        if(p==src)
            return;
        else{
            int x=findParent(p,parent);
         printParent(x,parent,src);
            System.out.print(x+", ");
           
        }
    }
    int findParent(int c,int[] parent){
        return parent[c];
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
        
        dij t = new dij();
        t.dijAlgo(graph, 1);
        
        
    }
    
}
