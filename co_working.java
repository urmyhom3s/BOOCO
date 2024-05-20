import java.util.Scanner;
public class co_working {
    static int rm_num;
    static int check;
    static int[][] co_working=new int[4][16];
    static int[] rm =new int[4];
    static int[] countseat =new int[4];
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        for(int i=1;i<=3;i++){
            rm[i]=0;
            countseat[i]=0;
        }
        for(int i = 1; i <=3; i += 1) {
            for(int j=1 ;j<=15;j+=1)
            co_working[i][j]=0;
        }
        System.out.println("Welcome to BOOCO !");
        //System.out.println("The meaning of each number");
        System.out.println("1 = show diagram of co-working space ");
        System.out.println("2 = book your room ");
        System.out.println("-1 = Thank you for using our servicef");
        while(true){
            System.out.print("choose function :");
            int func=sc.nextInt();
            if(func==1){
                showroom(rm);
            }
            if(func==2){
                rm_num=reserved_room(rm);
                System.out.println("3 = show diagram of the room ");
                System.out.println("4 = choose your seat ");
                System.out.println("5 = check out ");
                System.out.print("choose function in room :");
                func=sc.nextInt();
                if(func==3){
                    showtable(co_working[rm_num]);
                }else if(func==4){
                    reserved_table(co_working[rm_num]);
                }else if(func==5){
                    quit_room(co_working[rm_num]);
                    
                }
            }
            if(func==-1){
                System.out.println("end");
                break;
            }
        }
        sc.close();
    }
    static void showroom(int[] rm){
        for(int i=1;i<=3;i++){
            if(rm[i]==0){
                System.out.println(i+" empty");
            }else System.out.println(i+" full");
        }
    }
    static void showtable(int[] co_working){
        for(int i=1;i<=15;i++){
            if(i%5==0){
                if(co_working[i]==0){
                    System.out.println(i+" empty");
                }else System.out.println(i+" reserved");
            }else{
                if(co_working[i]==0){
                    System.out.print(i+ " empty ");
                }else System.out.print(i+ " reserved ");
            }
        }
    }
    static int reserved_room(int[] rm){
        System.out.print("please choose your room : ");
        int room=sc.nextInt();
        if(countseat[room]<15){
            return room;
        }else{
            System.out.print("if you want to check out press 5 ");
            check=sc.nextInt();
            if(check==5){
                quit_room(co_working[rm_num]);
                return 0;
            }else{
                System.out.println("this room is already reserved: ");
                System.out.println("please choose new room: ");
                return reserved_room(rm);
            } 
        }
    }
    static void reserved_table(int[] tab){ 
        System.out.print("please choose your seat : ");
        int table = sc.nextInt();
        if(tab[table]==0){
            tab[table]=1;
            countseat[rm_num]++;
            System.out.println("success! ");
        }else{
            System.out.println("this seat is already reserved: ");
            System.out.println("please choose your new seat: ");
            reserved_table(co_working[rm_num]);
        } 
    }
    static void quit_room(int[] co_working) {
        int user_quit = sc.nextInt();
        co_working[user_quit] = 0;
        System.out.println("good bye");
        countseat[rm_num]--;
        }
}