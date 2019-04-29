package croc.messenger.messenger.client;

import java.util.Random;

public final class Names {

	private static final Random rnd = new Random(System.currentTimeMillis());

	private static final String[] ROOTS = new String[] {
			"i"
	};

	private static final String[] PREFIXES = new String[] {
			"Nik"
	};

	private static final String[] SUFFIXES = new String[]{
			"ta",
	};

	private Names() {
		throw new IllegalStateException();
	}

	public static String randomName() {
		return PREFIXES[rnd.nextInt(PREFIXES.length)]
				+ ROOTS[rnd.nextInt(ROOTS.length)]
				+ SUFFIXES[rnd.nextInt(SUFFIXES.length)];
	}
}
