This is an example project SpringBoot + Exposed to resolve [this issue](https://github.com/JetBrains/Exposed/issues/831).

# How to setup

```sh
git clone THIS_REPOSITORY
./gradlew bootRun
```

# How to reproduce

```sh
# execute an API. It has two transaction to insert two User records.
wget http://localhost:8080/test/

# open h2
open http://localhost:8080/h2-console
```

h2 setting:
```
Setting: Generic H2 (Embedded)
Driver: org.h2.Driver
JDBC URL: jdbc:h2:~/exposed_test
```

Execute SQL:
```sql
SELECT * FROM USER USER;
```

We got only one user record...

```
ID  	LOGIN  	FIRSTNAME  	LASTNAME  	DESCRIPTION
1	no1_0.8841943731771981	one	one	Fri Mar 13 11:36:49 JST 2020
```

# exposed_ignored_transaction
