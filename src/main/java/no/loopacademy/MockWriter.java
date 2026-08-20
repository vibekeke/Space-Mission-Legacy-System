package no.loopacademy;

import java.io.Writer;

public class MockWriter extends Writer {

    private final StringBuilder content = new StringBuilder();

    @Override
    public void write(char[] cbuf, int off, int len) {
        content.append(cbuf, off, len);
    }

    @Override
    public void close() {

    }

    @Override
    public void flush() {

    }

    public String getContent() {
        return content.toString();
    }
}
