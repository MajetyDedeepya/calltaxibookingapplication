package taxibooking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class taxis {
	static int customerId;
	static char pickupPoint;
	static char dropPoint;
	static int pickupTime;
	static int bookingId=0;
	static ArrayList<taxi> taxilist=createTaxi();
	static List<String>booking_details=new ArrayList<>();
	public static  ArrayList<taxi> createTaxi(){
		ArrayList<taxi>taxi_list=new ArrayList<>();
		for(int i=0;i<4;i++) {
		taxi t=new taxi();
		taxi_list.add(t);
		//System.out.println(taxi_list.get(i).getId());
		}
		return(taxi_list);
		
	}
	public static ArrayList<taxi> freetaxi(char pickupPoint,int pickupTime){
		
		ArrayList<taxi>freeTaxi=new ArrayList<>();
		for(int i=0;i<taxilist.size();i++) {
			if(taxilist.get(i).getFreeTime()<=pickupTime&& Math.abs((taxilist.get(i).getStartingPoint()-'0')-(pickupPoint-'0'))<=pickupTime-taxilist.get(i).getFreeTime()) {
				freeTaxi.add(taxilist.get(i));
			}
		}
		
		return(freeTaxi);
		
	}
	public static void booking(int bookingId) {
		
		String details;
		int min=999;
		taxi bookedtaxi = null;
		int earning = 0;
		int dropTime = 0;
		int distanceblwpickuptodrop;
		int taxiNo;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter your customerid");
		customerId=sc.nextInt();
		System.out.println("enter your pickuppoint(a-f)");
		pickupPoint=sc.next().charAt(0);
		System.out.println("enter your destinationpoint(a-f)");
		dropPoint=sc.next().charAt(0);
		System.out.println("enter your pickuptime");
		pickupTime=sc.nextInt();
		ArrayList<taxi> freetaxis=freetaxi(pickupPoint,pickupTime);
		
		Collections.sort(freetaxis,(a,b)->a.getEarning() - b.getEarning());
		
		for(taxi t:freetaxis) {
			
			int distanceblwcustomertotaxi=Math.abs((t.getStartingPoint()-'0')-(pickupPoint-'0'))*15;
			if(distanceblwcustomertotaxi<min) {
				bookedtaxi=t;
				
				distanceblwpickuptodrop=(Math.abs(dropPoint-pickupPoint))*15;
				earning=(distanceblwpickuptodrop-5)*10+100;
				dropTime=pickupTime+distanceblwpickuptodrop/15;
				min=distanceblwcustomertotaxi;
			}
		}
		
		taxiNo=bookedtaxi.getId();
		bookedtaxi.setdetails(bookedtaxi.getId(),bookingId, customerId,earning, pickupPoint, pickupTime);
		details=taxiNo+" "+bookingId+" "+customerId+" "+pickupPoint+" "+dropPoint+" "+pickupTime+" "+dropTime+" "+earning;
		booking_details.add(details);
		
		bookedtaxi.setStartingPoint(dropPoint);
		bookedtaxi.setFreeTime(dropTime);
		
		System.out.println("taxi "+bookedtaxi.getId());
		
		//bookedtaxi=new taxi();
	}

	public static void main(String[] args) {
		
	    boolean value=true;
		while(value) {
		Scanner sc=new Scanner(System.in);
		System.out.println("1.booking");
		System.out.println("2.bookingdetails");
		System.out.println("3.taxidetails");
		System.out.println("4.exit");
		
		System.out.println("enter your choice");
		int choice=sc.nextInt();
		switch(choice) {
		case 1:
			booking(bookingId);
			bookingId++;
			break;
		case 2:
			
			for(int i=0;i<booking_details.size();i++) {
				
				String[] details=booking_details.get(i).split(" ");
				
				System.out.println("taxiId= "+details[0]+"\t"+"BookingId= "+details[1]+"\t"+"CustomerId= "+details[2]+"\t"+"pickupPoint="+details[3]+"\t"+"dropPoint= "+details[4]+
						"\t"+"pickupTime= "+details[5]+"\t"+"dropTime= "+details[6]+"\t"+"earning= "+details[7]);
			}
				
			break;
		case 3:
			int i=1;
				
				while(i<=4) {
					int TotalEarning=0;
					for(int j=0;j<booking_details.size();j++) {
						
						int v=booking_details.get(j).charAt(0)-'0';
						if(v==i) {
							String[] details=booking_details.get(j).split(" ");
							System.out.println("taxiId= "+details[0]+"\t"+"BookingId= "+details[1]+"\t"+"CustomerId= "+details[2]+"\t"+"pickupPoint="+details[3]+"\t"+"dropPoint= "+details[4]+
							"\t"+"pickupTime= "+details[5]+"\t"+"dropTime= "+details[6]+"\t"+"earning= "+details[7]);
				
					
					
							int earnings=Integer.parseInt(details[7]);
							TotalEarning+=earnings;
					
						}
			
				
					}
				System.out.println("Total earning= "+TotalEarning);
				
				i++;
				}
				
			
			
			
			break;
			
			
			
			
			
		case 4:
			value=false;
			break;
			
		
		
		
		// TODO Auto-generated method stub

	}
	}
	}

}
