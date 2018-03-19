class prims{
    int V=9;
    int minKey(int[] key,boolean [] mst){
        int min=Integer.MAX_VALUE;
        int min_index=-1;
        for(int v=0;v<V;v++){
            if(!mst[v] && key[v]<min){
                min=key[v];
                min_index=v;
            }
        }
        return min_index;
    }
    void primsAlgo(int[][] graph){
        boolean[] mst=new boolean[V];
        int[] key=new int[V];
        int[] parent=new int[V];
        for(int v=0;v<V;v++){
            mst[v]=false;
            key[v]=Integer.MAX_VALUE;
        }
        parent[0]=-1;
        key[0]=0;
        for(int count=0;count<V-1;count++){
            int u=minKey(key,mst);
            mst[u]=true;
            for(int v=0;v<V;v++){
                if(!mst[v] && graph[u][v]!=0 && graph[u][v]<key[v]){
                    key[v]=graph[u][v];
                    parent[v]=u;
                }
            }
        }
        print(graph,parent);
    }
    void print(int[][] graph,int[] parent){
        for(int i=1;i<V;i++)
            System.out.println(parent[i]+"-"+i+"\t"+graph[i][parent[i]]);
        
    }
    public static void main (String[] args)
    {
        
        prims t = new prims();
        int graph[][] = new int[][] {{0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        
        t.primsAlgo(graph);
    }
}
