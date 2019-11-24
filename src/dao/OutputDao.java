package dao;

import model.Bill;
import model.Record;
import model.Student;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;

public class OutputDao {
    //导出晚归记录方法
    public void output(List<Record> recordList) throws IOException {
        File file = new File("D:\\record.txt");
        FileOutputStream fos = new FileOutputStream(file);
        FileChannel channel = fos.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        String str = "日期"+"\t \t"+"学号\t \t"+"姓名\t \t"+"宿舍楼\t \t"+"宿舍\t \t"+"备注\n";
        buffer.put(str.getBytes());
        for(int i = 0;i < recordList.size();i++){
            String str1 = recordList.get(i).getDate()+"\t"+recordList.get(i).getStudentId()+"\t"+
                    recordList.get(i).getName()+"\t\t"+recordList.get(i).getDormBuild()+"\t\t"+
                    recordList.get(i).getDorm()+"\t\t";
            buffer.put(str1.getBytes());
            if(recordList.get(i).getDetail() == null){
                String str2 = "无\n";
                buffer.put(str2.getBytes());
            }else{
                String str2 = recordList.get(i).getDetail()+"\n";
                buffer.put(str2.getBytes());
            }
        }
        buffer.flip();
        channel.write(buffer);
        channel.close();
        fos.close();
    }

    //导出学生信息方法
    public void outputStu(List<Student> studentList) throws IOException {
        File file = new File("D:\\student.txt");
        FileOutputStream fos = new FileOutputStream(file);
        FileChannel channel = fos.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        String str ="学号\t \t"+"姓名\t \t"+"宿舍楼\t \t"+"宿舍\n";
        buffer.put(str.getBytes());
        for(int i = 0;i < studentList.size();i++){
            String str1 =studentList.get(i).getStudentId()+"\t"+
                    studentList.get(i).getName()+"\t\t"+studentList.get(i).getDormBuild()+"\t\t"+
                    studentList.get(i).getDorm()+"\n";
            buffer.put(str1.getBytes());
        }
        buffer.flip();
        channel.write(buffer);
        channel.close();
        fos.close();
    }

    //导出费用信息方法
    public void outputBill(List<Bill> billList) throws IOException {
        File file = new File("D:\\bill.txt");
        FileOutputStream fos = new FileOutputStream(file);
        FileChannel channel = fos.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        String str ="日期\t \t"+"宿舍楼\t \t"+"宿舍\t \t"+"费用\n";
        buffer.put(str.getBytes());
        for(int i = 0;i < billList.size();i++){
            String str1 =billList.get(i).getDate()+"\t"+billList.get(i).getDormBuild()+"\t\t"+
                    billList.get(i).getDorm()+"\t\t"+ billList.get(i).getCost()+"\n";
            buffer.put(str1.getBytes());
        }
        buffer.flip();
        channel.write(buffer);
        channel.close();
        fos.close();
    }
}
