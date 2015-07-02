import java.io.File;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;


public class FileUpload {
	private static String bucketName     = "mhartenbowerbucket";
	private static String keyName        = "1";
	private static String uploadFileName = "book.txt";
	
	public static void main(String[] args){
		//create a new AmazonS3Client object
		AmazonS3 client = new AmazonS3Client(new ProfileCredentialsProvider());
		System.out.println("Creating a new bucket......");
		try{
			client.createBucket(bucketName); //create a new bucket
			System.out.println("Uploading text file into specified bucket......");
			File fin = new File(uploadFileName);
			client.putObject(bucketName, keyName, fin); //put the specified text file into the bucket
		} catch(AmazonServiceException ase) {
			System.out.println("There was an error somewhere with the service..."); //need to add better error checking
		}
		
		catch(AmazonClientException ace) {
			System.out.println("There was an error somewhere with the client..."); //need to add better error checking
		}
	}
}

