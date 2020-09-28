package com.fetch.hierarchy;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;

//Class that will check the two versions given and return the proper HTML response
@Path ("/check")
public class ChechVersion {
	
	public String first;
	public String second;
	public String ans;
	
	
	//Function that handles the user not inputing either version
	@Produces(MediaType.TEXT_HTML)
	@GET
	public String zeroInputs(){
		return "Please submit two valid versions";
	}
	
	
	//Function that handles the user only inputing a single version
	@GET
	@Path("{input}")
	@Produces(MediaType.TEXT_HTML)
	public String oneInput(){
		return("Please submit two valid versions instead of one");
	}
	
	
	//Logic that figures out which version us after or before
	@GET
	@Path ("{vers1}/{vers2}")
	@Produces(MediaType.TEXT_HTML)
	public String getVers(@PathParam("vers1") String vers1,
						  @PathParam("vers2") String vers2){
		
		this.first = vers1;
		this.second = vers2;
		
		this.ans = this.first + " is ";
		
		//Converts both input strings into arrays split by "."
		String[] ver1 = this.first.split("\\.");
		String[] ver2 = this.second.split("\\.");
		
		int l1 = ver1.length;
		int l2 = ver2.length;
		
		int smaller = Math.min(l1, l2);
		int i;
		
		//Checks if both inputs are valid, i.e they do not contain letters or two periods at once
		for(String j : ver1){
			if(!j.matches("[0-9]+")){
				System.out.println(l1);
				return("Please submit a proper version syntax");
			}
		}
		for(String k : ver2){
			if(!k.matches("[0-9]+")){
				return("Please submit a proper version syntax");
			}
		}
		
		//Checks if the two versions are equal to each other
		if(this.first.equals(this.second)){
			return this.first + " is equal to " + this.second;
		}
		
		//Loop through the arrays and compare the values
		for(i = 0; i < smaller; i++){
			if(Integer.parseInt(ver1[i]) > Integer.parseInt(ver2[i])){
				ans += "after ";
				return ans + this.second;
			}
			else if(Integer.parseInt(ver1[i]) < Integer.parseInt(ver2[i])){
				ans += "before ";
				return ans + this.second;
			}
		}
		
		//check for rest of the versions to  see if they are filled with zeros
		if(smaller == l1){
			for(i = smaller; i < l2; i++){
				if(Integer.parseInt(ver2[i]) != 0){
					ans += "before ";
					return ans + this.second;
				}
			}
		}
		
		if(smaller == l2){
			for(i = smaller;i < l1; i++){
				if(Integer.parseInt(ver1[i]) != 0){
					ans += "after ";
					return ans + this.second;
				}
			}
		}
		
		return ans + "equal to " + this.second;
	}
	
	

}
