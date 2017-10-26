package Lab2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Simple rational number expression
 * 
 * @author UOrgil
 *
 */
public class SolveTerm {
	/**
	 * Constructor function
	 */
	public SolveTerm() {
		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.println("Илэрхийллээ оруул:");
			String expression = input.nextLine();
			ArrayList<Token> tokens = lex(expression);
			for (Token token : tokens)
				System.out.print(token.type + " ");
			System.out.println("\nҮр дүн: " + calculateExpression(tokens));
		}
	}

	/**
	 * Token type enum
	 */
	enum TokenType {
		NUM("\\d+/\\d+"), OPMUL("\\*"), OPDIV("/"), OPADD("\\+"), UNKNOWN(".+");

		public final String pattern;

		private TokenType(String pattern) {
			this.pattern = pattern;
		}
	}

	/**
	 * Token class
	 * 
	 * @author UOrgil
	 *
	 */
	class Token {
		public TokenType type;
		public String data;

		public Token(TokenType type, String data) {
			this.type = type;
			this.data = data;
		}

		@Override
		public String toString() {
			return String.format("(%s %s)", type.name(), data);
		}
	}

	/**
	 * String expression split tokens
	 * 
	 * @param input
	 *            Simple rational number expression string
	 * @return Tokens list
	 */
	private ArrayList<Token> lex(String input) {
		// The tokens to return
		ArrayList<Token> tokens = new ArrayList<Token>();

		// Lexer logic begins here
		StringBuffer tokenPatternsBuffer = new StringBuffer();
		for (TokenType tokenType : TokenType.values())
			tokenPatternsBuffer.append(String.format("|(?<%s>%s)", tokenType.name(), tokenType.pattern));
		Pattern tokenPatterns = Pattern.compile(new String(tokenPatternsBuffer.substring(1)));

		// Begin matching tokens
		Matcher matcher = tokenPatterns.matcher(input);
		while (matcher.find()) {
			if (matcher.group(TokenType.NUM.name()) != null) {
				tokens.add(new Token(TokenType.NUM, matcher.group(TokenType.NUM.name())));
				continue;
			} else if (matcher.group(TokenType.OPMUL.name()) != null) {
				tokens.add(new Token(TokenType.OPMUL, matcher.group(TokenType.OPMUL.name())));
				continue;
			} else if (matcher.group(TokenType.OPDIV.name()) != null) {
				tokens.add(new Token(TokenType.OPDIV, matcher.group(TokenType.OPDIV.name())));
				continue;
			} else if (matcher.group(TokenType.OPADD.name()) != null) {
				tokens.add(new Token(TokenType.OPADD, matcher.group(TokenType.OPADD.name())));
				continue;
			} else if (matcher.group(TokenType.UNKNOWN.name()) != null) {
				tokens.add(new Token(TokenType.UNKNOWN, matcher.group(TokenType.UNKNOWN.name())));
				continue;
			}
		}

		return tokens;
	}

	/**
	 * Calculate expression
	 * 
	 * @param tokens
	 *            Tokens list
	 * @return Expression value
	 */
	public RationalNumber calculateExpression(ArrayList<Token> tokens) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < tokens.size(); i++) {
			sb.append(tokens.get(i).type);
		}
		if (Pattern.matches(".*(UNKNOWN).*", sb.toString())) {
			return new RationalNumber();
		} else if (Pattern.matches("((NUM)((OPMUL)|(OPDIV)|(OPADD)))*(NUM)", sb.toString())) {
			return calculate(tokens, 0);
		} else {
			return new RationalNumber(-1);
		}
	}

	/**
	 * Calculate
	 * 
	 * @param tokens
	 *            Tokens list
	 * @param index
	 *            Expression first number index
	 * @return Expression value
	 */
	public RationalNumber calculate(ArrayList<Token> tokens, int index) {
		RationalNumber val = new RationalNumber(tokens.get(index).data);
		for (int i = index + 1; i < tokens.size(); i += 2) {
			if (tokens.get(i).type == TokenType.OPMUL) {
				val.mul(new RationalNumber(tokens.get(i + 1).data));
			} else if (tokens.get(i).type == TokenType.OPDIV) {
				val.div(new RationalNumber(tokens.get(i + 1).data));
			} else if (tokens.get(i).type == TokenType.OPADD) {
				if (i < tokens.size() - 2 && tokens.get(i + 2).type != TokenType.OPADD) {
					val.add(calculate(tokens, i + 1));
					break;
				}
				val.add(new RationalNumber(tokens.get(i + 1).data));
			}
		}
		return val;
	}

	/**
	 * Main function
	 * 
	 * @param args
	 *            Console input string array
	 */
	public static void main(String[] args) {
		new SolveTerm();
	}
}