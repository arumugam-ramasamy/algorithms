from collections import defaultdict
import queue

class G:
    def __init__(self):
        self.adj = defaultdict(dict)
        self.v = []
        self.ptbl = defaultdict(lambda:float("inf"))
        self.ctbl = defaultdict(lambda:float("inf"))
        self.res = []
    def addE(self,s,d, w = 1):
        self.adj[s][d] = w
    
    def clrV(self):
        self.v.clear()
    
    def dfs_nr(self,start):
        if (start == None):
            print("Start node is none")
            return(None)
            
        mstk = []
        res = []
        mstk.append(start)
        #new fix
        self.v.append(start)
        while (len(mstk) > 0):
            node = mstk.pop()
         #   if node not in self.v:
         
            print(node)
            res.append(node)
            #    self.v.append(node)
            for nbr in self.adj[node]:
                #print(nbr)
                if nbr not in self.v:
                    mstk.append(nbr)
                    self.v.append(nbr)
                        
        print(res)
        return(res)
    
    def dfs(self,start):
        if (start == None):
            return (None)
        
        if start not in self.v:
            print(start)
            self.v.append(start)
            self.res.append(start)
            for nbr in self.adj[start]:
  #              if nbr not in self.v:
                    self.dfs(nbr)

    def bfs(self,start):
        if (start == None):
            return(None)
        res = []
        q = queue.Queue()
        q.put(start)
        self.v.append(start)
        print("start", start)
        while (q.qsize() > 0):            
            node = q.get()
            print(node)
            res.append(node)
            for nbr in self.adj[node]:
                if nbr not in self.v:
                    q.put(nbr)
                    self.v.append(nbr)
    
        print(res)
        return(res)
    
        
        
g = G()
g.addE('A','B',6)
g.addE('A','C',4)
g.addE('B','D',3)
g.addE('C','B',1)
g.addE('C','E',6)
g.addE('E','D',3)
g.addE('D','F',2)
g.dfs_nr('A')

