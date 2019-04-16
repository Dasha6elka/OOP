package lab6.url;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.*;

public class HttpUrlTest {

    @Test
    public void initializationInputParametersTest() throws NoProtocolException, NoDocumentException, NoDomainException, MalformedURLException {
        URL url = new URL("https://example.com:99/docs/books/tutorial");
        HttpUrl.initializationInputParameters(url);
        assertEquals("https", HttpUrl.protocol);
        assertEquals("example.com", HttpUrl.domain);
        assertEquals("/docs/books/tutorial", HttpUrl.document);
    }

    @Test
    public void initUrlWithDomainError()throws MalformedURLException {
        URL url = new URL("https:///docs/books/tutorial");
        Throwable thrown = assertThrows(NoDomainException.class, () -> HttpUrl.initializationInputParameters(url));
        assertNotNull(thrown.getMessage());
    }

    @Test
    public void initUrlWithDocumentError()throws MalformedURLException {
        URL url = new URL("http://example.com/atstd/jfu::::123/jf_ir/kgir-spf");
        Throwable thrown = assertThrows(NoDocumentException.class, () -> HttpUrl.initializationInputParameters(url));
        assertNotNull(thrown.getMessage());
    }

    @Test
    public void initUrlWithProtocolError() {
        Throwable thrown = assertThrows(MalformedURLException.class, () -> new URL("httpss://example.com:99/docs/books/tutorial"));
        assertNotNull(thrown.getMessage());
    }

    @Test
    public void initUrlError() {
        Throwable thrown = assertThrows(MalformedURLException.class, () -> new URL("example.com"));
        assertNotNull(thrown.getMessage());
    }

    @Test
    public void httpUrlWork() throws NoProtocolException, NoDomainException, NoDocumentException, MalformedURLException {
        String line = "https://example.com:99/docs/books/tutorial";
        HttpUrl.httpUrl(line);
        assertEquals("https", HttpUrl.protocol);
        assertEquals("example.com", HttpUrl.domain);
        assertEquals(99, HttpUrl.port);
        assertEquals("/docs/books/tutorial", HttpUrl.document);
    }

    @Test
    public void httpUrlWithNotPortWork() throws NoProtocolException, NoDomainException, NoDocumentException, MalformedURLException {
        String line = "https://example.com/docs/books/tutorial";
        HttpUrl.httpUrl(line);
        assertEquals("https", HttpUrl.protocol);
        assertEquals("example.com", HttpUrl.domain);
        assertEquals(443, HttpUrl.port);
        assertEquals("/docs/books/tutorial", HttpUrl.document);
    }

    @Test
    public void httpUrlWithTreeParams() throws NoProtocolException, NoDomainException, NoDocumentException, MalformedURLException {
        HttpUrl.httpUrl("main.com", "/main/projects/labs", EProtocol.HTTP);
        assertEquals("main.com", HttpUrl.getDomain());
        assertEquals("/main/projects/labs", HttpUrl.getDocument());
        assertEquals(EProtocol.HTTP, HttpUrl.getProtocol());
        assertEquals("http://main.com/main/projects/labs", HttpUrl.getUrl());
    }

    @Test
    public void httpUrlWithFourParams() throws NoProtocolException, NoDomainException, NoDocumentException, MalformedURLException {
        HttpUrl.httpUrl("main.com", "/main/projects/labs", EProtocol.HTTP, 108);
        assertEquals("main.com", HttpUrl.getDomain());
        assertEquals("/main/projects/labs", HttpUrl.getDocument());
        assertEquals(EProtocol.HTTP, HttpUrl.getProtocol());
        assertEquals(108, HttpUrl.getPort());
        assertEquals("http://main.com:108/main/projects/labs", HttpUrl.getUrl());
    }

    @Test
    public void getUrlUnknownPortTest() throws NoProtocolException, NoDomainException, NoDocumentException, MalformedURLException {
        String line = "https://example.com:99/docs/books/tutorial";
        HttpUrl.httpUrl(line);
        assertEquals("https://example.com:99/docs/books/tutorial", HttpUrl.getUrl());
    }

    @Test
    public void getUrlKnownPortTest() throws NoProtocolException, NoDomainException, NoDocumentException, MalformedURLException {
        String line = "https://example.com:80/docs/books/tutorial";
        HttpUrl.httpUrl(line);
        assertEquals("https://example.com/docs/books/tutorial", HttpUrl.getUrl());
    }

    @Test
    public void getDomainTest() throws NoProtocolException, NoDomainException, NoDocumentException, MalformedURLException {
        String line = "https://example.com:99/docs/books/tutorial";
        HttpUrl.httpUrl(line);
        assertEquals("example.com", HttpUrl.getDomain());
    }

    @Test
    public void getDocumentTest() throws NoProtocolException, NoDomainException, NoDocumentException, MalformedURLException {
        String line = "https://example.com:80/docs/books/tutorial";
        HttpUrl.httpUrl(line);
        assertEquals("/docs/books/tutorial", HttpUrl.getDocument());
    }

    @Test
    public void getProtocolTest() throws NoProtocolException, NoDomainException, NoDocumentException, MalformedURLException {
        String line = "https://example.com:80/docs/books/tutorial";
        HttpUrl.httpUrl(line);
        assertEquals(EProtocol.HTTPS, HttpUrl.getProtocol());
    }

    @Test
    public void getPortTest() throws NoProtocolException, NoDomainException, NoDocumentException, MalformedURLException {
        String line = "https://example.com:99/docs/books/tutorial";
        HttpUrl.httpUrl(line);
        assertEquals(99, HttpUrl.getPort());
    }

    @Test
    public void getOnlyProtocolAndDomain() throws MalformedURLException, NoDocumentException, NoDomainException, NoProtocolException {
        String line = "http://vk.com";
        HttpUrl.httpUrl(line);
        assertEquals(EProtocol.HTTP, HttpUrl.getProtocol());
        assertEquals("vk.com", HttpUrl.getDomain());
    }
}
