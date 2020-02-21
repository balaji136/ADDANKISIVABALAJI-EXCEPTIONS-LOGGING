package EpamTask7;
import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


class InvalidSquareFeetException extends Exception{
	String exceptionalMessage;
	InvalidSquareFeetException(String exceptionalMessage){
		this.exceptionalMessage=exceptionalMessage;
	}
}
class HouseConstructionCost{
	float squareFeet;
	public static final Logger LOGGER=LogManager.getLogger(HouseConstructionCost.class);
	HouseConstructionCost(float squareFeet){
        try{
		if(squareFeet<0){
			throw new InvalidSquareFeetException("Negitive square feet has been entered");
		}
	
	}
	catch(InvalidSquareFeetException exceptionObject){
		
		LOGGER.error(exceptionObject.exceptionalMessage);
		System.exit(1);

	}
		this.squareFeet=squareFeet;
	}
	double standardMaterial(){
	
		return(squareFeet*1200);
	}
	double aboveStandardMaterial(){
		return(squareFeet*1500);
	}
	double highStandardMaterial(boolean fullyAutomation){

        if(fullyAutomation){
        	return(squareFeet*2500);
        }
        else{
        	return(squareFeet*1800);
        }
	}

}
class HouseConstructionCostEstimator{
	public static final Logger LOGGER=LogManager.getLogger(HouseConstructionCostEstimator.class);
	public static void main(String[] args){
		/*materaial standard    input_to_given
		  standard material     s
		  above standard        a
		  high standard         h
		  fully aumation        m
		*/
		  Scanner scanner=new Scanner(System.in);
		  boolean fullyAutomation=false;
		  LOGGER.info("Enter the number of sqaure feet:");
		  float squareFeet=scanner.nextFloat();
		  LOGGER.info("square feet:"+squareFeet);
		  LOGGER.info("Enter the material standard:");
		  char materialStandard=scanner.next().charAt(0);
		  LOGGER.info("material standard:"+materialStandard);
		  double houseMaterialCost;
		  HouseConstructionCost houseConstructionCost=new HouseConstructionCost(squareFeet);
		  if(materialStandard=='h'){
              materialStandard=scanner.next().charAt(0);
              if(materialStandard=='m')
              	fullyAutomation=true;
            houseMaterialCost=houseConstructionCost.highStandardMaterial(fullyAutomation);
            LOGGER.info("Total house material cost:"+houseMaterialCost);
		  }
		  else if(materialStandard=='s'){
		  	houseMaterialCost=houseConstructionCost.standardMaterial();
		  	LOGGER.info("Total house material cost:"+houseMaterialCost);
		  }
		  else if(materialStandard=='a'){
		  	houseMaterialCost=houseConstructionCost.aboveStandardMaterial();
		  	LOGGER.info("Total house material cost:"+houseMaterialCost);
		  }
		  else
		  	System.exit(1);//unsuccessful



      
	}
}
