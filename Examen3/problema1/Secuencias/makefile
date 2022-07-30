KC=	kotlinc
KFLAG=	-cp

all:	\
	Secuencia.class \
	Pila.class \
	Cola.class \
	TestSequencesKt.class

Secuencia.class: Secuencia.kt
	$(KC) Secuencia.kt

Pila.class: Pila.kt
	$(KC) $(KFLAG) . Pila.kt

Cola.class: Cola.kt
	$(KC) $(KFLAG) . Cola.kt

TestSequencesKt.class: TestSequences.kt 
	$(KC) $(KFLAG) . TestSequences.kt

clean:
	rm -rf *.class META-INF
