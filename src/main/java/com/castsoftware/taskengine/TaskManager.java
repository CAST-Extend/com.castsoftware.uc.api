package com.castsoftware.taskengine;

public class TaskManager {
	private static TaskList taskList;
		
	public static TaskList getTaskList() {
	    if (taskList == null)
	    	taskList = new TaskList();	
		
		return taskList;
	  }

}

