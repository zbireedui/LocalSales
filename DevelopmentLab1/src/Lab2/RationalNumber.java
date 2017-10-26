package Lab2;

import java.util.regex.Pattern;

/**
 * Rational number
 * 
 * @author UOrgil
 *
 */
public class RationalNumber {
	/**
	 * p
	 */
	private int p;
	/**
	 * q
	 */
	private int q;

	/**
	 * Constructor function
	 */
	public RationalNumber() {
		setRationalNumber(0, 1);
	}

	/**
	 * Constructor function parameters p and q
	 * 
	 * @param p
	 *            Set p
	 * @param q
	 *            Set q
	 */
	public RationalNumber(int p, int q) {
		setRationalNumber(p, q);
	}

	/**
	 * Constructor function parameter n
	 * 
	 * @param n
	 *            Set p to n and q to 1
	 */
	public RationalNumber(int n) {
		setRationalNumber(n, 1);
	}

	/**
	 * Constructor function parameters p and q
	 * 
	 * @param p
	 *            Set p
	 * @param q
	 *            Set q
	 */
	public RationalNumber(String p, String q) {
		setRationalNumber(Integer.parseInt(p), Integer.parseInt(q));
	}

	/**
	 * Constructor function parameter str
	 * 
	 * @param str
	 *            String to rational number
	 */
	public RationalNumber(String str) {
		if (Pattern.matches("\\d+/\\d+", str)) {
			String[] numbers = str.split("/");
			setRationalNumber(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]));
		} else if (Pattern.matches("\\d+", str)) {
			setRationalNumber(Integer.parseInt(str), 1);
		} else {
			setRationalNumber(1, 1);
		}
	}

	/**
	 * This addition rational number
	 * 
	 * @param rn
	 *            Addition rational number
	 */
	public void add(RationalNumber rn) {
		setRationalNumber(add(this, rn));
	}

	/**
	 * First addition second rational number
	 * 
	 * @param rn1
	 *            First rational number
	 * @param rn2
	 *            Second rational number
	 * @return Add rational number
	 */
	public static RationalNumber add(RationalNumber rn1, RationalNumber rn2) {
		return new RationalNumber(rn1.getP() * rn2.getQ() + rn2.getP() * rn1.getQ(), rn1.getQ() * rn2.getQ());
	}

	/**
	 * This subtraction rational number
	 * 
	 * @param rn
	 *            Subtraction rational number
	 */
	public void sub(RationalNumber rn) {
		setRationalNumber(sub(this, rn));
	}

	/**
	 * First subtraction second rational number
	 * 
	 * @param rn1
	 *            First rational number
	 * @param rn2
	 *            Second rational number
	 * @return Subtraction rational number
	 */
	public static RationalNumber sub(RationalNumber rn1, RationalNumber rn2) {
		return new RationalNumber(rn1.getP() * rn2.getQ() - rn2.getP() * rn1.getQ(), rn1.getQ() * rn2.getQ());
	}

	/**
	 * This multiplication rational number
	 * 
	 * @param rn
	 *            Multiplication rational number
	 */
	public void mul(RationalNumber rn) {
		setRationalNumber(mul(this, rn));
	}

	/**
	 * First multiplication second rational number
	 * 
	 * @param rn1
	 *            First rational number
	 * @param rn2
	 *            Second rational number
	 * @return Multiplication rational number
	 */
	public static RationalNumber mul(RationalNumber rn1, RationalNumber rn2) {
		return new RationalNumber(rn1.getP() * rn2.getP(), rn1.getQ() * rn2.getQ());
	}

	/**
	 * This division rational number
	 * 
	 * @param rn
	 *            Division rational number
	 */
	public void div(RationalNumber rn) {
		setRationalNumber(div(this, rn));
	}

	/**
	 * First division second rational number
	 * 
	 * @param rn1
	 *            First rational number
	 * @param rn2
	 *            Second rational number
	 * @return Division rational number
	 */
	public static RationalNumber div(RationalNumber rn1, RationalNumber rn2) {
		return new RationalNumber(rn1.getP() * rn2.getQ(), rn1.getQ() * rn2.getP());
	}

	/**
	 * To string function
	 */
	@Override
	public String toString() {
		return (p % q != 0) ? p + "/" + q : "" + p / q;
	}

	/**
	 * Get p
	 * 
	 * @return return P
	 */
	public int getP() {
		return p;
	}

	/**
	 * Set p
	 * 
	 * @param p
	 *            Set p
	 */
	public void setP(int p) {
		this.p = p;
	}

	/**
	 * Get q
	 * 
	 * @return return Q
	 */
	public int getQ() {
		return q;
	}

	/**
	 * Set q
	 * 
	 * @param q
	 *            Set q
	 */
	public void setQ(int q) {
		this.q = q;
	}

	/**
	 * Greatest common divisor
	 * 
	 * @param a
	 *            First number
	 * @param b
	 *            Second number
	 * @return Greatest common divisor
	 */
	private int gcd(int a, int b) {
		while (b > 0) {
			int tmp = b;
			b = a % b;
			a = tmp;
		}
		return a;
	}

	/**
	 * Set rational number
	 * 
	 * @param rn
	 *            Set rational number
	 */
	private void setRationalNumber(RationalNumber rn) {
		setRationalNumber(rn.getP(), rn.getQ());
	}

	/**
	 * Set rational number
	 * 
	 * @param p
	 *            Set p
	 * @param q
	 *            Set q
	 */
	private void setRationalNumber(int p, int q) {
		this.p = p;
		this.q = (q == 0) ? 1 : q;
		consume();
	}

	/**
	 * Consume rational number
	 */
	private void consume() {
		int tmp = gcd(p, q);
		p /= tmp;
		q /= tmp;
	}
}