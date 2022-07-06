package com.example.gli.Exer11.list.exer;

/**
 * @author gsuiy
 * @create 2022-04-30 16:01
 */
public class CustomArrayList {
    String[]strarray = new String[10];
    int Indxt=0;
    public void add( String str){

       strarray[Indxt++] =str;
    }

    /**
     * 默认移除最后一个有数据
     */
    public void remove(){
        if(Indxt > 0){
            strarray[Indxt-1] = null;
            Indxt--;
        }else {
            System.out.println("无数据");
        }
    }

    /**
     * -1:没数据 -2：越界
     * @param Index
     * @return
     */
    public String get(int Index){
        if(this.Indxt >= Indxt){
            // 没数据
            return "-1";
        }else{
            return strarray[Index];
        }

    }

    public void map(){
        for (int i = 0; i < strarray.length; i++) {
            System.out.println("i=" + i+"-" +strarray[i]);
        }
    }

}
