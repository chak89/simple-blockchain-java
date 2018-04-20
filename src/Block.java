import java.time.Instant;

public class Block {

	public int blocknumber;
	public String hash;
	public String previousHash;
	public long timeStamp;
	private String data;
	
	
	
	public Block(int blocknumber, String previousHash, String data) {
		this.blocknumber = blocknumber;
		this.previousHash = previousHash;
		this.timeStamp = Instant.now().toEpochMilli();
		this.data = data;
	}
}
