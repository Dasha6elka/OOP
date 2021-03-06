package lab6.url;

import java.net.MalformedURLException;
import java.net.URL;

class HttpUrl {
    static String protocol;
    static String domain;
    static int port = 0;
    static String document;

    static void initializationInputParameters(URL myUrl) throws NoProtocolException, NoDomainException, NoDocumentException {
        protocol = myUrl.getProtocol();
        domain = myUrl.getHost();
        document = myUrl.getFile();
        if (protocol == null) {
            throw new NoProtocolException("Not protocol in " + "'" + myUrl + "'");
        }
        if (domain.isEmpty()) {
            throw new NoDomainException("Not domain in " + "'" + myUrl + "'");
        }

        boolean isString = false;
        boolean isQuest = false;
        boolean isEqual = false;
        for (int i = 0; i < document.length(); i++) {
            char ch = document.charAt(i);
            if (ch == '?') {
                isQuest = true;
            }
            if (!isQuest && ch == '"') {
                throw new NoDocumentException("Not document in " + "'" + myUrl + "'");
            }
            if (ch == '=' && !isQuest) {
                throw new NoDocumentException("Not document in " + "'" + myUrl + "'");
            }
            if (ch == '=') {
                isEqual = true;
            }
            if (ch == '"' && !isEqual) {
                throw new NoDocumentException("Not document in " + "'" + myUrl + "'");
            }
            if (ch == '"') {
                if (isString) {
                    isString = false;
                    continue;
                } else {
                    isString = true;
                    continue;
                }
            }
            if (i == document.length() - 1 && isString) {
                throw new NoDocumentException("Not document in " + "'" + myUrl + "'");
            }
            if (!Character.isLetterOrDigit(ch) &&
                ch != '-' && ch != '_' && ch != '/' &&
                ch != '?' && ch != '!' && ch != '*' &&
                ch != '~' && ch != '=' && ch != '(' &&
                ch != ')' && ch != '.' && ch != '%' &&
                ch != '+' && ch != '&' && ch != '#' &&
                !isString) {
                throw new NoDocumentException("Not document in " + "'" + myUrl + "'");
            }
        }
    }

    static void httpUrl(String url) throws NoProtocolException, NoDocumentException, NoDomainException, MalformedURLException {
        if (url.charAt(0) != 'h') {
            url = "http://" + url;
        }
        URL myUrl = new URL(url);
        initializationInputParameters(myUrl);
        port = myUrl.getPort();
        if (0 > port || port > 65535) {
            port = -1;
        }
        if (port == -1 && protocol.equalsIgnoreCase(EProtocol.HTTP.name())) {
            port = 80;
        }
        if (port == -1 && protocol.equalsIgnoreCase(EProtocol.HTTPS.name())) {
            port = 443;
        }
    }

    static String getUrl() {
        if (port == 80 || port == 443 || port == 0) {
            return (protocol + "://" + domain + document);
        }
        return (protocol + "://" + domain + ":" + port + document);
    }

    static String getDomain() {
        return domain;
    }

    static String getDocument() {
        return document;
    }

    static EProtocol getProtocol() {
        if (protocol.equalsIgnoreCase(EProtocol.HTTP.name())) {
            return EProtocol.HTTP;
        } else {
            return EProtocol.HTTPS;
        }
    }

    static int getPort() {
        return port;
    }

    static void httpUrl(String domain, String document, EProtocol protocol) throws NoProtocolException, NoDocumentException, NoDomainException, MalformedURLException {
        HttpUrl.domain = domain;
        HttpUrl.document = document;
        HttpUrl.protocol = String.valueOf(EProtocol.HTTP);
        URL myUrl = new URL(HttpUrl.protocol + "://" + HttpUrl.domain + HttpUrl.document);
        initializationInputParameters(myUrl);
    }

    static void httpUrl(String domain, String document, EProtocol protocol, int port) throws NoProtocolException, NoDocumentException, NoDomainException, MalformedURLException {
        HttpUrl.domain = domain;
        HttpUrl.document = document;
        HttpUrl.port = port;
        HttpUrl.protocol = String.valueOf(EProtocol.HTTP);
        URL myUrl = new URL(HttpUrl.protocol + "://" + HttpUrl.domain + ":" + HttpUrl.port + HttpUrl.document);
        initializationInputParameters(myUrl);
    }
}
