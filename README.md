# corejava2
**use this core java repository and ignore old one**

check this one

Understand the difference between these 2 methods code the way it is written ie you can write retun statement effectively as follows.

public static SingletonEx getInstance(){
		
		
		  if(singleton_instance==null) 
			 **return new SingletonEx();
		  else
			  return singleton_instance**;
	}
 
 public static synchronized Singleton getInstance(){
        if (single_instance == null)
            single_instance = new Singleton();
  
        **return single_instance**;
    }
