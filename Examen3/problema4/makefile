KC=	kotlinc
KFLAG=	-cp

all:	\
	Clase.class \
	Manejador.class \
	MainKt.class

Clase.class: Clase.kt
	$(KC) Clase.kt

Manejador.class: Manejador.kt
	$(KC) $(KFLAG) . Manejador.kt

MainKt.class: Main.kt 
	$(KC) $(KFLAG) . Main.kt

clean:
	rm -rf *.class META-INF
