KC=	kotlinc
KFLAG=	-cp

all:	\
	GrafoDirigido.class \
	Vertices.class \
	Busqueda.class \
	BFS.class \
	TestBusquedaGrafoKt.class

GrafoDirigido.class: GrafoDirigido.kt
	$(KC) GrafoDirigido.kt

Vertices.class: Vertices.kt
	$(KC) Vertices.kt

Busqueda.class: Busqueda.kt
	$(KC) $(KFLAG) . Busqueda.kt

BFS.class: BFS.kt
	$(KC) $(KFLAG) . BFS.kt

TestBusquedaGrafoKt.class: TestBusquedaGrafo.kt 
	$(KC) $(KFLAG) . TestBusquedaGrafo.kt

clean:
	rm -rf *.class META-INF
