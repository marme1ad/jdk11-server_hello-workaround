# jdk11-server_hello-workaround

There is a bug [JDK-8209965](https://bugs.openjdk.java.net/browse/JDK-8209965) in the JDK 11 GA (build 28) release related to _SSL_/_TLS_ (_JSSE_ module) handshake (_server_hello_ part):

Quotation from the __JDK-8209965__:
> <...> it appears that the server is sending a "supported_groups" extension in its ServerHello message (TLSv1.2). Reading about it, this seems to be a common issue with certain servers and certain SSL implementations have added support to be lenient with such servers https://github.com/openssl/openssl/pull/4463/files

---

This is a PoC for a client-side workaround for _Stack Overflow_ [question >>](https://stackoverflow.com/questions/52414255/maven-with-jdk-11-fails-when-downloading-a-wrong-dependency-with-extension-10). It contains two classes:

  - `Fetch.java` - reproduces the issue, example (a little bit adjusted) is from the Java Mailing Lists [here >>](http://mail.openjdk.java.net/pipermail/security-dev/2018-August/018005.html)
  - `FetchWorkaround.java` - workaround, which uses different from _JSSE_ implementation of _SSL_/_TLS_ (in our case it is [BouncyCastle](https://www.bouncycastle.org/)

To test simply run `run.sh` and `runWorkaround.sh` scripts (`run.bat` and `runWorkaround.bat` for _Windows OS_).
