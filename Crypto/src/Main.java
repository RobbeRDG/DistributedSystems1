import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.xml.bind.DatatypeConverter;
import java.lang.reflect.Array;
import java.security.*;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws Exception {
        //Create 3 persons
        Person person1 = new Person("person1", "Gent", "0496351668");
        Person person1Fake = new Person("persnn1", "Gent", "0496351668");
        Person person2 = new Person("person2", "Lokeren", "0496334416");

        //Serialize all the persons in byte arrays
        byte[] person1Bytes = person1.getBytes();
        byte[] person1FakeBytes = person1Fake.getBytes();
        byte[] person2Bytes = person2.getBytes();

        //Hashing
        System.out.println("Hashing person1 and person1Fake");
        byte[][] personsBytes = {person1Bytes, person1FakeBytes};
        hashPersons(personsBytes);
        System.out.println();


        //symmetrical encryption
        System.out.println("Testing symmetrical encryption");
        String testString = "Hello world";
        symmetricalEncryptionTest(testString);
        System.out.println();

        //asymmetrical encryption
        System.out.println("Testing asymmetrical encryption");
        asymmetricalEncryptionTest(testString);
        System.out.println();
    }




    //**********************************************************************************************************************
    //     HASHING
    //**********************************************************************************************************************
    private static void hashPersons(byte[][] personsBytes) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        for (byte[] personBytes: personsBytes) {
            byte[] hashedPerson = digest.digest(personBytes);
            System.out.println(DatatypeConverter.printHexBinary(hashedPerson));
        }
    }





    //**********************************************************************************************************************
    //     SYMMETRICAL ENCRYPTION
    //**********************************************************************************************************************
    private static void symmetricalEncryptionTest(String testString) throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException {
        //First create a symmetrical key
        SecretKey symmetricalKey = generateSymmetricalKey();

        //Create an initialization vector
        byte[] initializationVector = createInitializationVector();

        //Encrypt the testString
        byte[] symmetricalEncryptedBytes = symmetricalEncryptString(testString, symmetricalKey, initializationVector);

        //Decrypt the encryptedText
        String symmetricalDecryptedText = symmetricalDecryptString(symmetricalEncryptedBytes, symmetricalKey, initializationVector);

        //Compare the decrypted text and the original test string
        System.out.println("Original string: " + testString);
        System.out.println("Decrypted string: " + symmetricalDecryptedText);

    }




    private static SecretKey generateSymmetricalKey() throws NoSuchAlgorithmException {
        // Creating the SecureRandom object
        SecureRandom secureRandom = new SecureRandom();

        // We can invoke the following method
        // to retrieve random bytes
        byte bytes[] = new byte[20];
        secureRandom.nextBytes(bytes);

        KeyGenerator keygenerator = KeyGenerator.getInstance("AES");
        keygenerator.init(256, secureRandom);

        //Generate and return the key
        SecretKey key = keygenerator.generateKey();
        return key;
    }

    private  static byte[] createInitializationVector() {
        byte[] initializationVector
                = new byte[16];
        SecureRandom secureRandom
                = new SecureRandom();
        secureRandom.nextBytes(initializationVector);
        return initializationVector;
    }

    private static byte[] symmetricalEncryptString(String testString, SecretKey symmetricalKey, byte[] initializationVector) throws NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");

        IvParameterSpec ivParameterSpec = new IvParameterSpec(initializationVector);

        cipher.init(Cipher.ENCRYPT_MODE, symmetricalKey, ivParameterSpec);

        return cipher.doFinal(testString.getBytes());
    }

    private static String symmetricalDecryptString(byte[] encryptedBytes, SecretKey symmetricalKey, byte[] initializationVector) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");

        IvParameterSpec ivParameterSpec = new IvParameterSpec(initializationVector);

        cipher.init(Cipher.DECRYPT_MODE, symmetricalKey, ivParameterSpec);

        byte[] result = cipher.doFinal(encryptedBytes);

        return new String(result);
    }





    //**********************************************************************************************************************
    //     ASYMMETRICAL ENCRYPTION
    //**********************************************************************************************************************
    private static void asymmetricalEncryptionTest(String testString) throws Exception {
        //First generate a public and private key pair
        KeyPair keyPair = generateKeyPair();

        //Place both keys in different variables
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        //Print the public key
        System.out.println("Public Key is: " + DatatypeConverter.printHexBinary(publicKey.getEncoded()));

        //encrypt the test String with the the private key
        byte[] assymetricalEncryptedBytes = asymmetricalEncryptString(testString, privateKey);

        //decrypt the bytes using the public key
        String asymmetricalDecryptedText = asymmetricalDecryptString(assymetricalEncryptedBytes, publicKey);

        //Compare the decrypted text and the original test string
        System.out.println("Original string: " + testString);
        System.out.println("Decrypted string: " + asymmetricalDecryptedText);
    }

    private static KeyPair generateKeyPair() throws NoSuchAlgorithmException {
        SecureRandom secureRandom = new SecureRandom();

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");

        keyPairGenerator.initialize(2048, secureRandom);

        return keyPairGenerator.generateKeyPair();
    }

    public static byte[] asymmetricalEncryptString(String testString, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");

        cipher.init(Cipher.ENCRYPT_MODE, privateKey);

        return cipher.doFinal(testString.getBytes());
    }

    public static String asymmetricalDecryptString(byte[] encryptedBytes, PublicKey publicKey) throws Exception
    {
        Cipher cipher = Cipher.getInstance("RSA");

        cipher.init(Cipher.DECRYPT_MODE, publicKey);

        byte[] result = cipher.doFinal(encryptedBytes);

        return new String(result);
    }
}
