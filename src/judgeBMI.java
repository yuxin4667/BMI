import java.util.*;//�ޤJ�u���Ʈw
public class judgeBMI {
	
	public static double standardW(double H, double W, double bmi)//�p��n�W�δ�魫�q
	{
		double suggestW;//�ܼ�:��ĳ�W���魫�q
		if(bmi<18.5)//�Y�L���A�hsuggestW���W���q
			suggestW=18.5*H*H-W;
		else//�Y�L���A�hsuggestW����q
			suggestW=W-24*H*H;
		return (Math.round(suggestW*100.0)/100.0);
	}	
	
	public static void judge(double H, double W, double bmi)//���P�_
	{
		double suggestW;
		//nested if/else
		if(bmi>=18.5 && bmi<24)//�魫���`
		{
			System.out.println("�魫���`�A�~��O��");
		}
		else //�魫���`
		{
			suggestW=standardW(H, W, bmi);//��ĳ�W���魫�q
			if(bmi<18.5)
				System.out.println("�魫�L���A��ĳ�W���ܤ�"+suggestW+"����");
			else if(bmi<27)
				System.out.println("�L���A��ĳ��ܤ�"+suggestW+"����");
			else if(bmi<30)
				System.out.println("���תέD�A��ĳ��ܤ�"+suggestW+"����");
			else if(bmi<35)
				System.out.println("���תέD�A��ĳ��ܤ�"+suggestW+"����");
			else
				System.out.println("���תέD�A��ĳ��ܤ�"+suggestW+"����");
		}
	}

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		double height, weight, bmi; //�]�ܼ�:�����A�魫�Abmi��
		int input=0;//�]�ܼ�:���(���F��switch)
		
		while(input!=2)//�i���ƿ�J
		{
			//switch�s�@��J���
			System.out.print("�аݧA�Q�n1.�p��bmi 2.���}:");
			input=sc.nextInt();
			switch(input)
			{
			case 1:
				while(true)
				{
					System.out.print("�п�J����(����):");//��J�����s�J�ܼ�
					height=sc.nextDouble();
					if(height>2.5 || height<0.35)//if��condition operator�P�_�O�_�X�z����
					{
						System.out.println("��J�������šA�Э��s��J");
						continue;//�������X�z�A�A����J����
					}
					break;//�����X�z�A���X�j��i��U�@�B
				}
				
				while(true)
				{
					System.out.print("�п�J�魫(����):");//��J�魫�s�J�ܼ�
					weight=sc.nextDouble();	
					if(weight<5)//if�P�_�O�_�X�z����
					{
						System.out.println("��J�魫���šA�Э��s��J");//�魫���X�z�A�A����J����
						continue;
					}
					break;//�魫�X�z�A���X�j��i��U�@�B
				}
				bmi=weight/(height*height);//�p��BMI
				bmi=Math.round(bmi*100.0)/100.0;//BMI�|�ˤ��J��p���I���
				System.out.println("�z��BMI��"+bmi);//�L�XBMI
				
				judge(height, weight, bmi);//�P�_���
				break;
			
			case 2://���}
				System.out.println("BYE!");
				break;
			default://����J�Ȧ��~
				System.out.println("�п��1�άO2");
				break;
			}
			System.out.println("---------------------------");
		}
		
		sc.close();//����Scanner
	}
}
