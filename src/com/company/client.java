package com.company;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

        public class client {
            public static void main(String[] args) {
                //initialize socket and input output streams
                Socket socket = null;
                InputStreamReader inputStreamReader = null;
                OutputStreamWriter outputStreamWriter = null;
                BufferedReader bufferedReader = null;
                BufferedWriter bufferedWriter = null;

                try {
                    socket = new Socket("localhost", 1234);
                    inputStreamReader = new InputStreamReader(socket.getInputStream());
                    outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

                    //Both input and outputStreams are wrapped by bufferReader and writer respectively to improve efficiency
                    bufferedReader = new BufferedReader(inputStreamReader);
                    bufferedWriter = new BufferedWriter(outputStreamWriter);

                    Scanner scanner = new Scanner(System.in);

                    //while loop will run forever because it is always true
                    while (true) {
                        String msgToSend = scanner.nextLine();

                        //sending message to the server
                        bufferedWriter.write(msgToSend);
                        //newLine() writes a line separator to the  underlying streams
                        bufferedWriter.newLine();
                        //flush method is called when buffer is full and it is for efficiency
                        bufferedWriter.flush();

                        System.out.println("Server: " + bufferedReader.readLine());

                        if (msgToSend.equalsIgnoreCase("BYE"))
                            break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        // checking for null before closing the streams to avoid NullPointerExceptions
                        if (socket != null)
                            socket.close();
                        if (inputStreamReader != null)
                            inputStreamReader.close();
                        if (outputStreamWriter != null)
                            outputStreamWriter.close();
                        if (bufferedReader != null)
                            bufferedReader.close();
                        if (bufferedWriter != null)
                            bufferedWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }