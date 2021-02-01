import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;


import com.google.protobuf.InvalidProtocolBufferException;


public class ListPeople {
    public static void main(String[] args) throws Exception {
        System.out.println("hello, world");
        Message.Person.Builder builder = Message.Person.newBuilder();

        builder.setAge(10);
        builder.setFirstName("hello");
        builder.setLastName("good");
        builder.setAddress("on earth");

        Message.Person person = builder.build();

        byte[] result = person.toByteArray() ;
        String outputFile = "person.pb";
        try {
            OutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(result);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        testdec(result);
      }

    public static boolean tupleReturn(byte[] result,
                                      ResultSet receiver) throws SQLException {
        try {
            Message.Person person = Message.Person.parseFrom(result);
            receiver.updateInt(1, person.getId());
            receiver.updateString(2, person.getLastName());
            receiver.updateString(3, person.getFirstName());
            receiver.updateString(4, person.getAddress());
            receiver.updateInt(5, person.getAge());
            return true;
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        throw new SQLException("invalid IntWithMod value");
    }

    public static boolean testdec(byte[] result) throws InvalidProtocolBufferException {
        Message.Person person = Message.Person.parseFrom(result);
        System.out.println("after id:" + person.getId());
        System.out.println("after name:" + person.getLastName());
        System.out.println("after email:" + person.getAge());

        return true;
    }
}