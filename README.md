## 关于数据结构和算法的学习（基于java）

1、自定义数组，支持动态扩容、缩容 

    时间复杂度： 
        查询：O(1)，增删O(n)
2、自定义队列，包括普通队列和循环队列
    
    时间复杂度：
        普通队列：入队：O(1)  均摊，出队：O(n)
        循环队列：入队：O(1)  均摊，出队：O(1)  均摊
        优先队列：底层基于数组实现时入队 O(1)  出队O(n)
                 底层基于链表实现时入队 O(n)  出队O(1)
                 底层基于最大堆实现时  入队出队 O(logn)
    优先队列的经典问题：
        在1000000元素中选出前100名？（在N个元素中选出前M个元素  (N>>M)）
        排序后选出前100？ 快排、归并等时间复杂度 nlogn
        而优先队列   nlogm   
        因此在n很大m很小的情况下，优先队列会比排序快几倍
            思路：使用优先队列维护前m个元素，前m个最大的元素中不断剔除最小的元素
        
3、自定义链表

    时间复杂度：
        增删：O(n)，查找：O(n)
        (只对链表头进行操作时间复杂度：O(1))
        
    扩展：这里就有个问题了，既然数组和链表的增删时间复杂度都是O(n)，为什么很多地方都说数组适合查询，链表适合增删呢，时间复杂度不都是O(n)的吗？
         实际上数组增删过后要移动增删元素之后的所有元素，而链表增删是因为需要查询到待增删元素前一个元素，查找比移动数据耗时短很多，所以说同样
    是O(n)，但是实际上链表增删快很多。
        
4、自定义栈，底层分别是数组实现和链表实现

    时间复杂度：
        底层基于数组实现：入栈：O(1)  均摊，出栈：O(1)  均摊
            时间复杂度之所以加上均摊是因为入栈出栈要触发resize操作，数据要移动
        底层基于链表实现：入栈：O(1)，出栈：O(1)
            虽然链表的增删时间复杂度是O(n)，但是用于实现栈时，只用操作链表的头结点，对头结点的添加删除操作来说时间复杂度降低为O(1)。
    分析：当数据量小的时候十万数量级以下，耗时：数组栈>链表栈，当数据量大的时候，耗时：链表栈>数组栈
        原因：数组栈要触发resize操作，就会存在数组扩容后数据的移动，比较耗时；而数据量太大时，链表栈的new Node()更加耗时。当然和jvm版本和操
        作系统的不同也有一定影响。
        
5、二分搜索树

    时间复杂度：
        增删查：O(logn)

6、集合 && 映射  （Set && Map）

    时间复杂度：
        底层基于链表实现：O(n)
        底层基于二分查找树实现：O(logn)

7、堆

    时间复杂度：
        添加元素、取出最大元素：O(logn)
        
8、线段树
    
    动态区间问题
    时间复杂度：
        查询：O(logn) 更新：O(logn)
        
9、并查集
    
    高效处理连接问题
    使用数组模拟的Quick Find：isConnected    O(1)
                            unionElements  O(n)
    
    优化后的并查集：O(logh)-->O(log*n)=1+log*(logn)  h为并查集这棵"树"的高度
       注：O(log*n)= 0              n<=1
          O(log*n)=1+log*(logn)    n>1    近乎是O(1)级别的
          
    