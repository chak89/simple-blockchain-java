import java.time.Instant;

public class Block {

	public int blocknumber;
	public String hash;
	public String previousHash;
	public long timeStamp;
	private String data;
	
	
	//Block constructor
	public Block(int blocknumber, String previousHash, String data) {
		this.blocknumber = blocknumber;
		this.previousHash = previousHash;
		this.timeStamp = Instant.now().toEpochMilli();
		this.data = data;
		this.hash = calculateHash();
	}
	
	
	//Helper function for calculating the hash
	public String calculateHash() {
		
		String stringtoHash = previousHash + Long.toString(timeStamp) + data;
		String hashedString = HashSHA256.sha256(stringtoHash);
		return hashedString;
	}
}
