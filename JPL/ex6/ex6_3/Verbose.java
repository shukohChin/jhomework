package ex6.ex6_3;

public interface Verbose {
	enum MessageLevel{
		SILENT, TERSE, NORMAL, VERBOSE,
	}

	void setVerbosity(MessageLevel level);
	MessageLevel getVerbosity();
}
