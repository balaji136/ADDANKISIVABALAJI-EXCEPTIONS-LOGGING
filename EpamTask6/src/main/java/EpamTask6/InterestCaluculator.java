package EpamTask6;
import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class InvalidPrincipleException extends Exception{
	String exceptionalMessage;
   InvalidPrincipleException(String exceptionalMessage){
   	this.exceptionalMessage=exceptionalMessage;
   }
}
class InvalidTimeException extends Exception{
	String exceptionalMessage;
	InvalidTimeException(String exceptionalMessage){
		this.exceptionalMessage=exceptionalMessage;
	}
}
class InvalidRateOfInterestException extends Exception{
	String exceptionalMessage;
	InvalidRateOfInterestException(String exceptionalMessage){
		this.exceptionalMessage=exceptionalMessage;
	}
}

class Interest{
	int principle;
	int time;
	int rate_of_interest;
	public static final Logger LOGGER=LogManager.getLogger(Interest.class);
	Interest(int principle,int time,int rate_of_interest){
		 this.principle=principle;
		    this.time=time;
		    this.rate_of_interest=rate_of_interest;

		

      }

	double simpleInterestCaluculator(){
		return((principle*time*rate_of_interest)/100);
	}
	double compoundInterestCaluculator(){
		return((principle*Math.pow((1+(rate_of_interest/100)),time))-principle);
	}

}
public class InterestCaluculator{
	public static final Logger LOGGER=LogManager.getLogger(Interest.class);
	public static void main(String args[]){
		Scanner scanner=new Scanner(System.in);
		int principle=0;
		int time=0;
		
		int rate_of_interest=0;
		try{
			LOGGER.info("Enter the principle amount:");
			principle=scanner.nextInt();
			if(principle<0)
				throw new InvalidPrincipleException("Negitive principle has been entered");
			else
				LOGGER.info("principle amount:"+principle);
			LOGGER.info("Enter time:");
			time=scanner.nextInt();
			if(time<0)
				throw new InvalidTimeException("Negitive time has been entered");
			else
				LOGGER.info("time:"+time);
			LOGGER.info("Enter the rate of interest:");
			rate_of_interest=scanner.nextInt();	
			if(rate_of_interest<0)
				throw new InvalidRateOfInterestException("Negitive rate of interest has been entered");
			else
				LOGGER.info("rate of interest:"+rate_of_interest);
				
			
          }
          catch(InvalidPrincipleException exceptionalObject){
        	    LOGGER.info("principle amount:"+principle);
               	LOGGER.error(exceptionalObject.exceptionalMessage);
               	System.exit(1);
            }
            catch(InvalidTimeException exceptionalObject){
            	LOGGER.info("time:"+time);
               	LOGGER.error(exceptionalObject.exceptionalMessage);
               	System.exit(1);
            }
            catch(InvalidRateOfInterestException exceptionalObject){
            	LOGGER.info("rate of interest:"+rate_of_interest);
               	LOGGER.error(exceptionalObject.exceptionalMessage);
               	System.exit(1);
            }
		
		
		
		
		/*caluculate          input
		  simple Interest     simple
		  compound Interest   compound
		 */
		LOGGER.info("Enter the choice to calucualte either simple or compound:");
		String userChoiceToCaluculate=scanner.next();
		Interest interest=new Interest(principle,time,rate_of_interest);
		double simple_interest;
		double compound_interest;
		if("simple".equalsIgnoreCase(userChoiceToCaluculate)) {
		     simple_interest = interest.simpleInterestCaluculator();
		     LOGGER.info("simple interest:"+simple_interest);
		 }
		else if("compound".equalsIgnoreCase(userChoiceToCaluculate)){


			 compound_interest = interest.compoundInterestCaluculator();
			 LOGGER.info("compound inteterest:"+compound_interest);
			}
		else {
			LOGGER.info("invalid operation has been entered please check again!!");
		}
		scanner.close();
}
}


