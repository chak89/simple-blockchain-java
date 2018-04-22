import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class Blockchain {

	public static ArrayList<Block> blockchain = new ArrayList<Block>(); 
	
	public static void main(String[] args) {
		
		blockchain.add(new Block(blockchain.size()+1,"0","Testing with genesis block"));
		blockchain.add(new Block(blockchain.size()+1,blockchain.get(blockchain.size()-1).hash,"Testing with second block"));
		blockchain.add(new Block(blockchain.size()+1,blockchain.get(blockchain.size()-1).hash,"Testing with third block"));
		
		
		//Json views
		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);		
		System.out.println(blockchainJson);

		System.out.println(validChain());
		
	}
	
	//Check chains integrity
	public static Boolean validChain() {

		for(int i=blockchain.size()-1; i>0; i--) {
			Block latestBlock = blockchain.get(i);
			Block previousBlock = blockchain.get(i-1);
			
			if(!latestBlock.previousHash.equals(previousBlock.hash)) {
				System.out.println("Latest block previous hash doesn't match previous block hash");
				return false;
			}
		}
		return true;
	}
}
