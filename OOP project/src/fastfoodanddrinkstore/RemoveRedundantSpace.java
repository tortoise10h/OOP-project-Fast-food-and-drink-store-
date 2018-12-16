package fastfoodanddrinkstore;

public class RemoveRedundantSpace {
	private String myStr;
	public RemoveRedundantSpace(String myStr) {
		this.myStr = myStr;
	}
	public RemoveRedundantSpace() {}
	public String removeSpace(String myStr) {
		String newStr = myStr.trim();
		int newStrLength = newStr.length();
		String cleanStr = "";
		for(int i = 0; i < newStrLength; i++) {
			if(newStr.substring(i, i+1).equals(" ") == false || newStr.substring(i,i+1).equals(" ") && newStr.substring(i+1,i+2).equals(" ") ==  false){
				cleanStr += newStr.substring(i,i+1);
			}
		}
		return cleanStr;
	}
}
