import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public class ReaderThread implements Runnable{

    protected BlockingQueue<String> blockingQueue;

    public ReaderThread(BlockingQueue<String> blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    public String parser(String buffer) {
        String[] strList = buffer.split(" ");
        // System.out.println(Arrays.toString(strlist));
        int res = 0;
        boolean sign = true;
        for (String s: strList) {
            if (s.equals("-")) sign = false;
            else if(s.equals("+")) sign = true;
            else {
                res += (sign? Integer.parseInt(s): - Integer.parseInt(s));
            }
        }
        return String.valueOf(res);
    }
    @Override
    public void run() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("./input.txt"));
            String buffer;
            while((buffer=br.readLine())!=null){
                if (buffer.isEmpty()) continue;;
                blockingQueue.put(parser(buffer));
            }
            blockingQueue.put("EOF");  //When end of file has been reached

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        } catch(InterruptedException e){

        }finally{
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }



}