package kamski.mac;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<CreditCard> listOfCreditCards = new ArrayList<>();
		listOfCreditCards.add(new CreditCard("Master", 10000, 230));
		listOfCreditCards.add(new CreditCard("Master", 20000, 230));
		listOfCreditCards.add(new CreditCard("Master", 20000, 330));
		listOfCreditCards.add(new CreditCard("VISA", 10000, 230));
		listOfCreditCards.add(new CreditCard("American Express", 10000, 230));

		System.out.println("list before sorting:\n" + listOfCreditCards);
		compareBeforeJava8(listOfCreditCards);
		compareAfterJava8(listOfCreditCards);

	}

	private static void compareAfterJava8(List<CreditCard> creditCards) {
		List<CreditCard> tempListOfCreditCards = new ArrayList<CreditCard>();
		tempListOfCreditCards.addAll(creditCards);
		// in Java 8 using Comparator.comparing and Comparator.thenComparing
		// and method reference
		Comparator<CreditCard> compareByProviderThenCreditLimitInJDK8 = Comparator.comparing(CreditCard::getProvider)
				.thenComparing(CreditCard::getCreditLimit).thenComparingInt(CreditCard::getFee);
		tempListOfCreditCards.sort(compareByProviderThenCreditLimitInJDK8);
		System.out.println("Comparing after Java 8:\n" + tempListOfCreditCards);
	}

	private static void compareBeforeJava8(List<CreditCard> creditCards) {
		List<CreditCard> tempListOfCreditCards = new ArrayList<CreditCard>();
		tempListOfCreditCards.addAll(creditCards);
		// comparing before Java 8 e.g. Java SE 6 or Java SE 7
		System.out.println("Comparing before Java 8: ");
		Comparator<CreditCard> compareByProviderThenCreditLimit = new Comparator<CreditCard>() {
			public int compare(CreditCard first, CreditCard second) {
				int i = first.getProvider().compareTo(second.getProvider());
				if (i != 0)
					return i;
				i = first.getCreditLimit() - second.getCreditLimit();
				if (i != 0)
					return i;

				return Integer.compare(first.getFee(), second.getFee());
			}
		};
		// comparing by provider, creditlimit and then fee using Java 7 way
		tempListOfCreditCards.sort(compareByProviderThenCreditLimit);
		System.out.println(tempListOfCreditCards);
	}
}
