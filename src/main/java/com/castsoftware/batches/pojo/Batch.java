package com.castsoftware.batches.pojo;

public class Batch implements Comparable<Batch> {
		private String name;
		private String description;
		private String fullPath;
		
		public int compareTo(Batch batch)
		{
			return name.compareTo(batch.getName());
		}
		
		public String getName() 
		{
			return name;
		}
		
		public void setName(String name) 
		{
			this.name = name;
		}
		
		public String getDescription() 
		{
			return description;
		}
		
		public void setDescription(String description) 
		{
			this.description = description;
		}
		
		public String getFullPath() 
		{
			return fullPath;
		}
		
		public void setFullPath(String fullPath) 
		{
			this.fullPath = fullPath;
		}

}
