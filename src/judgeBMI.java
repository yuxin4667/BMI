import java.util.*;//引入工具資料庫
public class judgeBMI {
	
	public static double standardW(double H, double W, double bmi)//計算要增或減的體重量
	{
		double suggestW;//變數:建議增減體重量
		if(bmi<18.5)//若過輕，則suggestW為增重量
			suggestW=18.5*H*H-W;
		else//若過重，則suggestW為減重量
			suggestW=W-24*H*H;
		return (Math.round(suggestW*100.0)/100.0);
	}	
	
	public static void judge(double H, double W, double bmi)//體位判斷
	{
		double suggestW;
		//nested if/else
		if(bmi>=18.5 && bmi<24)//體重正常
		{
			System.out.println("體重正常，繼續保持");
		}
		else //體重異常
		{
			suggestW=standardW(H, W, bmi);//建議增減體重量
			if(bmi<18.5)
				System.out.println("體重過輕，建議增重至少"+suggestW+"公斤");
			else if(bmi<27)
				System.out.println("過重，建議減重至少"+suggestW+"公斤");
			else if(bmi<30)
				System.out.println("輕度肥胖，建議減重至少"+suggestW+"公斤");
			else if(bmi<35)
				System.out.println("中度肥胖，建議減重至少"+suggestW+"公斤");
			else
				System.out.println("重度肥胖，建議減重至少"+suggestW+"公斤");
		}
	}

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		double height, weight, bmi; //設變數:身高，體重，bmi值
		int input=0;//設變數:選單(為了用switch)
		
		while(input!=2)//可重複輸入
		{
			//switch製作輸入選單
			System.out.print("請問你想要1.計算bmi 2.離開:");
			input=sc.nextInt();
			switch(input)
			{
			case 1:
				while(true)
				{
					System.out.print("請輸入身高(公尺):");//輸入身高存入變數
					height=sc.nextDouble();
					if(height>2.5 || height<0.35)//if及condition operator判斷是否合理的值
					{
						System.out.println("輸入身高不符，請重新輸入");
						continue;//身高不合理，再次輸入身高
					}
					break;//身高合理，跳出迴圈進行下一步
				}
				
				while(true)
				{
					System.out.print("請輸入體重(公斤):");//輸入體重存入變數
					weight=sc.nextDouble();	
					if(weight<5)//if判斷是否合理的值
					{
						System.out.println("輸入體重不符，請重新輸入");//體重不合理，再次輸入身高
						continue;
					}
					break;//體重合理，跳出迴圈進行下一步
				}
				bmi=weight/(height*height);//計算BMI
				bmi=Math.round(bmi*100.0)/100.0;//BMI四捨五入到小數點兩位
				System.out.println("您的BMI為"+bmi);//印出BMI
				
				judge(height, weight, bmi);//判斷體位
				break;
			
			case 2://離開
				System.out.println("BYE!");
				break;
			default://選單輸入值有誤
				System.out.println("請選擇1或是2");
				break;
			}
			System.out.println("---------------------------");
		}
		
		sc.close();//關閉Scanner
	}
}
