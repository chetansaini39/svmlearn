import svmlearn.*;

public class Main {
	public static void main(String [] args) {  
		SVM s = new SVM();
		
		Problem train = new Problem();
		Problem test = new Problem();
//		train.loadProblem("G:\\!data\\lshtc\\proba2\\train.txt");
//		test.loadProblem("G:\\!data\\lshtc\\proba2\\test.txt");
		train.loadBinaryProblem("G:\\!data\\lshtc\\reuters\\train.txt");
		test.loadBinaryProblem("G:\\!data\\lshtc\\reuters\\test.txt");

		System.out.println("Loaded.");
		System.out.println("Training...");
//		KernelParams kp = new KernelParams(2,1,1,1);
//		s.svmTrain(train, kp, 0);
		s.svmTrain(train);
		System.out.println("Testing...");
		int [] pred = s.svmTest(test);
		for (int i=0; i<pred.length; i++)
			System.out.println(pred[i]);
		
		EvalMeasures e = new EvalMeasures(test, pred, 2);
		System.out.println("Accuracy=" + e.Accuracy());
		
		System.out.println("Done.");
		System.out.println("END");
	}
}