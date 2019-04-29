package croc.messenger.messenger.common;

import java.util.Objects;

public class User {

	private final String name;

	public User(String name) {
		Objects.requireNonNull(name);

		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "@" + name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name.toLowerCase());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof User))
			return false;
		User user = (User)obj;
		return Objects.equals(
				name.toLowerCase(),
				user.name.toLowerCase());
	}
}
