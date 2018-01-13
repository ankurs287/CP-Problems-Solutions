import java.util.Arrays;
import java.util.Comparator;

public class Sort {

static final Comparator<Address> ORDER_BY_STREETNAME = new Comparator<Address>() {
	public int compare(Address a1, Address a2) {
		return a1.streetName.compareTo(a2.streetName);
	}
};
static final Comparator<Address> ORDER_BY_STREETNUMBER = new Comparator<Address>() {
	public int compare(Address a1, Address a2) {
		return a1.streetNumber.compareTo(a2.streetNumber);
	}
};
static final Comparator<Address> ORDER_BY_CITY = new Comparator<Address>() {
	public int compare(Address a1, Address a2) {
		return a1.city.compareTo(a2.city);
	}
};

static final Comparator<Address> ORDER_BY_RULES = new Comparator<Address>() {
	public int compare(Address a1, Address a2) {
		int i = ORDER_BY_STREETNAME.compare(a1,a2);
		if(i == 0){
			i = ORDER_BY_STREETNUMBER.compare(a1,a2);
			if(i == 0){
				i = ORDER_BY_CITY.compare(a1,a2);
			}
		}
		return i;
	}
};

public static void main(String args[]){
	//Array with address to sort
	Address[] addressArray = new Address[]{
		new Address("univ dr","101", "Sunshine", "FL", "33324"),
		new Address("break rd","102", "Sunrise", "FL", "33224"),
		new Address("univ dr","103", "Cleveland", "OH", "24785"),
		new Address("dykes rd","104", "San Antonio", "TX", "24785"),
		new Address("dykes rd","104", "Boston", "MA", "24785"),
		new Address("dykes rd","104", "Orlando", "FL", "24783"),
	};
	Arrays.sort(addressArray, ORDER_BY_RULES);
	//Print the sorted array
	for(int i=0; i<addressArray.length; i++){
		System.out.println(addressArray[i].toString());
	}
	System.out.println();
}
}

//Address Class
class Address {
	String streetName;
	String streetNumber;
	String city;
	String state;
	String zipCode;
	@Override
	public String toString() {
		return "Address [" + streetName + " | " + streetNumber + " | " +
			city + " | " + state + " | " + zipCode + "]";
	}
	public Address(String streetName, String streetNumber,
				String city, String state, String zipCode) {
		super();
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
}