import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Requester {
    Socket requestSocket;
    ObjectOutputStream out;
    ObjectInputStream in;
    String message;
    String response;
    String response2;
    Scanner input;

    Requester() {
        input = new Scanner(System.in);
    }

    void run() {
        try {
            // Create a socket to connect to the server
            requestSocket = new Socket("127.0.0.1", 2006);
            System.out.println("Connected to localhost");

            // Get Input and Output streams for communication with the server
            out = new ObjectOutputStream(requestSocket.getOutputStream());
            out.flush();
            in = new ObjectInputStream(requestSocket.getInputStream());

            // Client Communications
            try {
                do {
                    // Read and display the message from the server
                    message = (String) in.readObject();
                    System.out.println(message);

                    // Get user response
                    response = input.nextLine();
                    // Send the user response to the server
                    sendMessage(response);

                    //Receives messages from if user chooses to register account
                    if (response.equalsIgnoreCase("1")) {
                        message = (String) in.readObject();
                        System.out.println(message);

                        response = input.nextLine();
                        sendMessage(response);

                        message = (String) in.readObject();
                        System.out.println(message);

                        response = input.nextLine();
                        sendMessage(response);

                        message = (String) in.readObject();
                        System.out.println(message);

                        response = input.nextLine();
                        sendMessage(response);

                        message = (String) in.readObject();
                        System.out.println(message);

                        response = input.nextLine();
                        sendMessage(response);

                        message = (String) in.readObject();
                        System.out.println(message);

                        response = input.nextLine();
                        sendMessage(response);

                        message = (String) in.readObject();
                        System.out.println(message);

                        response = input.nextLine();
                        sendMessage(response);

                        // User login
                    } else if (response.equalsIgnoreCase("2")) {
                        message = (String) in.readObject();
                        System.out.println(message);

                        response = input.nextLine();
                        sendMessage(response);

                        message = (String) in.readObject();
                        System.out.println(message);

                        response = input.nextLine();
                        sendMessage(response);

                        message = (String) in.readObject();

                        if (message.equalsIgnoreCase("Not found")) {
                            System.out.println(message);
                        } else {
                            String[] result = message.split("[*]");
                            System.out.println("\nSuccessfully logged in!\n");
                            System.out.println("Name: " + result[0]);
                            System.out.println("PPS Number: " + result[1]);
                            System.out.println("Email: " + result[2]);
                            System.out.println("Password: (hidden)");
                            System.out.println("Address: " + result[4]);
                            System.out.println("Initial Balance: " + result[5] + "\n");
                            do {
                                System.out.println(
                                        "\n\nEnter 1 to show all registered users\n2 to add money to your account\n3 to transfer funds\n4 to change password\n5 to view previous transactions\nOr any other button to exit ");

                                response2 = input.nextLine();
                                sendMessage(response2);

                                //Show all registered users
                                if (response2.equalsIgnoreCase("1")) {

                                    message = (String) in.readObject();

                                    int temp = Integer.parseInt(message);

                                    for (int i = 0; i < temp; i++) {
                                        message = (String) in.readObject();

                                        String[] result1 = message.split("[*]");

                                        System.out.println("Name: " + result1[0]);
                                        System.out.println("PPS Number: " + result1[1]);
                                        System.out.println("Email: " + result1[2]);
                                        System.out.println("Password: (hidden)");
                                        System.out.println("Address: " + result1[4]);
                                        System.out.println("Initial Balance: " + result1[5] + "\n");

                                    }
                                }

                                //Add money to account
                                if (response2.equalsIgnoreCase("2")) {

                                    message = (String) in.readObject();
                                    System.out.println(message);

                                    response = input.nextLine();
                                    sendMessage(response);

                                    message = (String) in.readObject();
                                    System.out.println(message);

                                    response = input.nextLine();
                                    sendMessage(response);

                                    message = (String) in.readObject();
                                    System.out.println(message);
                                }

                                //Transfer funds
                                if (response2.equalsIgnoreCase("3")) {

                                    message = (String) in.readObject();
                                    System.out.println(message);

                                    response = input.nextLine();
                                    sendMessage(response);

                                    message = (String) in.readObject();
                                    System.out.println(message);

                                    response = input.nextLine();
                                    sendMessage(response);

                                    message = (String) in.readObject();
                                    System.out.println(message);

                                    response = input.nextLine();
                                    sendMessage(response);

                                    message = (String) in.readObject();
                                    System.out.println(message);

                                    response = input.nextLine();
                                    sendMessage(response);

                                    message = (String) in.readObject();
                                    System.out.println(message);

                                    response = input.nextLine();
                                    sendMessage(response);

                                    message = (String) in.readObject();
                                    System.out.println(message);

                                    response = input.nextLine();
                                    sendMessage(response);

                                    message = (String) in.readObject();
                                    System.out.println(message);

                                }

                                //Change password
                                if (response2.equalsIgnoreCase("4")) {
                                    message = (String) in.readObject();
                                    System.out.println(message);

                                    response = input.nextLine();
                                    sendMessage(response);

                                    message = (String) in.readObject();
                                    System.out.println(message);

                                    response = input.nextLine();
                                    sendMessage(response);

                                    message = (String) in.readObject();
                                    System.out.println(message);
                                }

                                //View previous transactions
                                if (response2.equalsIgnoreCase("5")) {
                                    message = (String) in.readObject();
                                    System.out.println(message);

                                    response = input.nextLine();
                                    sendMessage(response);
                                    System.out.println("\n" + response + "'s transactions:\n");

                                    message = (String) in.readObject();

                                    int temp = Integer.parseInt(message);

                                    for (int i = 0; i < temp; i++) {
                                        message = (String) in.readObject();

                                        String[] result2 = message.split("[*]");

                                        System.out.println("Transaction: " + result2[0]);

                                    }
                                }
                            } while (response2.equalsIgnoreCase("1") || response2.equalsIgnoreCase("2") ||
                                    response2.equalsIgnoreCase("3") || response2.equalsIgnoreCase("4")
                                    || response2.equalsIgnoreCase("5"));
                        }

                    }

                    // Message repeats and asks if user wants to login/register or exit
                    message = (String) in.readObject();
                    System.out.println(message);

                    response = input.nextLine();
                    sendMessage(response);

                } while (response.equalsIgnoreCase("1"));

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            //Error
        } catch (UnknownHostException unknownHost) {
            System.err.println("You are trying to connect to an unknown host!");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            // Closing connection
            try {
                in.close();
                out.close();
                requestSocket.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    // Send a message to the server
    void sendMessage(String msg) {
        try {
            out.writeObject(msg);
            out.flush();
            System.out.println("client>" + msg);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void main(String args[]) {
        // Create Instance of Requester and run
        Requester client = new Requester();
        client.run();
    }
}