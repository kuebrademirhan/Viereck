import static org.junit.Assert.*;
import java.lang.reflect.*;
import org.junit.*;
import java.util.*;

public class ViereckePublicTest {
	// ========== SYSTEM ==========
	protected static final String EX_NAME_Vierecke = "Vierecke";
	// --------------------

	// ========== TEST-DATA ==========
	private final Random RND = new Random(4711_0815_666L);
	private static final double PRECISION = 1e-7;

	// -------------------- Punkt --------------------
	@Test(timeout = 1000)
	public void pubTest__Punkt__INTESTINES__IF_THIS_VERY_IMPORTANT_TEST_FAILS_THEN_YOU_WILL_GET_NO_POINTS_AT_ALL() {
		Class<?> clazz = Punkt.class;
		assertTrue(clazz + " must be public!", Modifier.isPublic(clazz.getModifiers()));
		assertFalse(clazz + " must not be abstract!", Modifier.isAbstract(clazz.getModifiers()));
		assertFalse(clazz + " must not be an annotation!", clazz.isAnnotation());
		assertFalse(clazz + " must not be an enumeration!", clazz.isEnum());
		assertFalse(clazz + " must not be an interface!", clazz.isInterface());
		assertSame(clazz + " must extend a certain super-class!", Object.class, clazz.getSuperclass());
		assertEquals(clazz + " must implement a certain number of interfaces!", 0, clazz.getInterfaces().length);
		assertEquals(clazz + " must declare a certain number of inner annotations!", 0, clazz.getDeclaredAnnotations().length);
		assertEquals(clazz + " must declare a certain number of inner classes!", 0, getDeclaredClasses(clazz).length);
		Field[] fields = getDeclaredFields(clazz);
		assertEquals(clazz + " must declare a certain number of fields!", 2, fields.length);
		for (Field field : fields) {
			assertTrue(field + " - field must be private!", Modifier.isPrivate(field.getModifiers()));
			assertFalse(field + " - field must not be static!", Modifier.isStatic(field.getModifiers()));
			assertTrue(field + " - field must be final!", Modifier.isFinal(field.getModifiers()));
			assertSame(field + " - field must have a certain type!", double.class, field.getType());
			assertTrue(field + " - field must have a certain name!", field.getName().equals("x") || field.getName().equals("y"));
		}
		Constructor<?>[] constructors = getDeclaredConstructors(clazz);
		assertEquals(clazz + " must declare a certain number of constructors (possibly including default constructor)!", 1, constructors.length);
		for (Constructor<?> constructor : constructors) {
			assertTrue(constructor + " - constructor must be public!", Modifier.isPublic(constructor.getModifiers()));
			assertEquals(constructor + " - constructor must have a certain number of parameters!", 2, constructor.getParameterTypes().length);
			for (Class<?> parameterType : constructor.getParameterTypes()) {
				assertSame(constructor + " - constructor must have parameters with certain types!", double.class, parameterType);
			}
			assertEquals(constructor + " - constructor must have parameters with certain names!", "x", constructor.getParameters()[0].getName());
			assertEquals(constructor + " - constructor must have parameters with certain names!", "y", constructor.getParameters()[1].getName());
		}
		Method[] methods = getDeclaredMethods(clazz);
		assertEquals(clazz + " must declare a certain number of methods!", 2, methods.length);
		for (Method method : methods) {
			assertTrue(method + " - method must be public!", Modifier.isPublic(method.getModifiers()));
			assertFalse(method + " - method must not be static!", Modifier.isStatic(method.getModifiers()));
			assertFalse(method + " - method must not be abstract!", Modifier.isAbstract(method.getModifiers()));
			assertSame(method + " - method must have a certain return type!", double.class, method.getReturnType());
			assertTrue(method + " - method must have a certain name!", method.getName().equals("holeX") || method.getName().equals("holeY"));
			assertEquals(method + " - method must have a certain number of parameters!", 0, method.getParameterTypes().length);
		}
	}

	@Test(timeout = 1000)
	public void pubTest__INTESTINES_SMOKE_TEST__IF_THIS_VERY_IMPORTANT_TEST_FAILS_THEN_YOU_WILL_GET_NO_POINTS_AT_ALL() {
		for (Class<?> clazz : new Class[]{Drachenviereck.class, Parallelogramm.class, Trapez.class, Rechteck.class, Quadrat.class, Raute.class}) {
			assertTrue(clazz + " must be public!", Modifier.isPublic(clazz.getModifiers()));
			assertFalse(clazz + " must not be abstract!", Modifier.isAbstract(clazz.getModifiers()));
			assertFalse(clazz + " must not be an annotation!", clazz.isAnnotation());
			assertFalse(clazz + " must not be an enumeration!", clazz.isEnum());
			assertFalse(clazz + " must not be an interface!", clazz.isInterface());
			assertEquals(clazz + " must implement a certain number of interfaces!", 0, clazz.getInterfaces().length);
			assertEquals(clazz + " must declare a certain number of inner annotations!", 0, clazz.getDeclaredAnnotations().length);
			assertEquals(clazz + " must declare a certain number of inner classes!", 0, getDeclaredClasses(clazz).length);
			Constructor<?>[] constructors = getDeclaredConstructors(clazz);
			assertEquals(clazz + " must declare a certain number of constructors (possibly including default constructor)!", 1, constructors.length);
			for (Constructor<?> constructor : constructors) {
				assertTrue(constructor + " - constructor must be public!", Modifier.isPublic(constructor.getModifiers()));
			}
		}
		for (Class<?> clazz : new Class[]{Drachenviereck.class, Parallelogramm.class, Trapez.class}) {
			Field[] fields = getDeclaredFields(clazz);
			assertEquals(clazz + " must declare a certain number of fields!", 3, fields.length);
			for (Field field : fields) {
				assertFalse(field + " - field must not be static!", Modifier.isStatic(field.getModifiers()));
				assertSame(field + " - field must have a certain type!", double.class, field.getType());
			}
			Method[] methods = getDeclaredMethods(clazz);
			assertEquals(clazz + " must declare a certain number of methods!", 2, methods.length);
			for (Method method : methods) {
				assertTrue(method + " - method must be public!", Modifier.isPublic(method.getModifiers()));
				assertFalse(method + " - method must not be static!", Modifier.isStatic(method.getModifiers()));
				assertFalse(method + " - method must not be abstract!", Modifier.isAbstract(method.getModifiers()));
				assertSame(method + " - method must have a certain return type!", double.class, method.getReturnType());
				assertTrue(method + " - method must have a certain name!", method.getName().equals("flaecheninhalt") || method.getName().equals("umfang"));
				assertEquals(method + " - method must have a certain number of parameters!", 0, method.getParameterTypes().length);
			}
		}
		for (Class<?> clazz : new Class[]{Rechteck.class, Quadrat.class, Raute.class}) {
			Field[] fields = getDeclaredFields(clazz);
			assertEquals(clazz + " must declare a certain number of fields!", 0, fields.length);
			Method[] methods = getDeclaredMethods(clazz);
			assertEquals(clazz + " must declare a certain number of methods!", 0, methods.length);
		}
	}

	// -------------------- Punkt --------------------
	@Test(timeout = 1000)
	public void pubTest__Punkt__holeX_holeY__IF_THIS_VERY_IMPORTANT_TEST_FAILS_THEN_YOU_WILL_MOST_PROBABLY_GET_NO_POINTS_AT_ALL() {
		for (int pass = 0; pass < 42; pass++) {
			double expectedX = 4711 - 666 * RND.nextDouble(), expectedY = 4711 - 666 * RND.nextDouble();
			Punkt p = new Punkt(expectedX, expectedY);
			double actualX = p.holeX(), actualY = p.holeY();
			assertEquals("Punkt.holeX failed.", expectedX, actualX, PRECISION);
			assertEquals("Punkt.holeY failed.", expectedY, actualY, PRECISION);
		}
	}

	// -------------------- ViereckKonvex --------------------
	@Test(timeout = 1000)
	public void pubTest__ViereckKonvex__holeX_berechneXY__IF_THIS_VERY_IMPORTANT_TEST_FAILS_THEN_YOU_WILL_PROBABLY_GET_NO_POINTS_AT_ALL() {
		Punkt[] pX = {new Punkt(2, 1), new Punkt(5, 0), new Punkt(6, 4), new Punkt(1, 3)};
		Viereck v = new ViereckKonvex(pX[0], pX[1], pX[2], pX[3]) {
			@Override
			public double umfang() {
				return 42;
			}

			@Override
			public double flaecheninhalt() {
				return 666;
			}
		};
		assertSame("ViereckKonvex.holeA failed.", pX[0], v.holeA());
		assertSame("ViereckKonvex.holeB failed.", pX[1], v.holeB());
		assertSame("ViereckKonvex.holeC failed.", pX[2], v.holeC());
		assertSame("ViereckKonvex.holeD failed.", pX[3], v.holeD());
		double actualAB = v.berechneAB(), actualBC = v.berechneBC(), actualCD = v.berechneCD(), actualDA = v.berechneDA();
		assertEquals("ViereckKonvex.berechneAB failed.", 10, actualAB * actualAB, PRECISION);
		assertEquals("ViereckKonvex.berechneBC failed.", 17, actualBC * actualBC, PRECISION);
		assertEquals("ViereckKonvex.berechneCD failed.", 26, actualCD * actualCD, PRECISION);
		assertEquals("ViereckKonvex.berechneDA failed.", 5, actualDA * actualDA, PRECISION);
	}

	// -------------------- Quadrat --------------------
	@Test(timeout = 1000)
	public void pubTest__Quadrat__holeX_berechneXY_flaecheninhalt_umfang() {
		for (double[] xya : new double[][]{{47, 11, 666}, {0.815, 42.666, 42}}) {
			Punkt pP = new Punkt(xya[0], xya[1]);
			Viereck vq = new Quadrat(pP, xya[2]);
			assertSame("Quadrat.holeA failed.", pP, vq.holeA());
			assertEquals("Quadrat.holeB.holeX failed.", xya[0] + xya[2], vq.holeB().holeX(), PRECISION);
			assertEquals("Quadrat.holeB.holeY failed.", xya[1], vq.holeB().holeY(), PRECISION);
			assertEquals("Quadrat.holeC.holeX failed.", xya[0] + xya[2], vq.holeC().holeX(), PRECISION);
			assertEquals("Quadrat.holeC.holeY failed.", xya[1] + xya[2], vq.holeC().holeY(), PRECISION);
			assertEquals("Quadrat.holeD.holeX failed.", xya[0], vq.holeD().holeX(), PRECISION);
			assertEquals("Quadrat.holeD.holeY failed.", xya[1] + xya[2], vq.holeD().holeY(), PRECISION);
			assertEquals("Quadrat.berechneAB failed.", xya[2], vq.berechneAB(), PRECISION);
			assertEquals("Quadrat.berechneBC failed.", xya[2], vq.berechneBC(), PRECISION);
			assertEquals("Quadrat.berechneCD failed.", xya[2], vq.berechneCD(), PRECISION);
			assertEquals("Quadrat.berechneDA failed.", xya[2], vq.berechneDA(), PRECISION);
			double actualArea = vq.flaecheninhalt(), actualCircumference = vq.umfang();
			assertEquals("Quadrat.flaecheninhalt failed.", xya[2] * xya[2], actualArea, PRECISION);
			assertEquals("Quadrat.umfang failed.", 4 * xya[2], actualCircumference, PRECISION);
		}
	}

	// -------------------- ViereckKonvex.flaecheninhalt --------------------
	@Test(timeout = 1000)
	public void pubTest__ViereckKonvex__Viereck_flaecheninhalt() {
		double a1 = 0.815 + 666 * RND.nextDouble(), a3 = 0.815 + 666 * RND.nextDouble();
		Viereck[] vs = {null, new Quadrat(new Punkt(4711 - 666 * RND.nextDouble(), 4711 - 666 * RND.nextDouble()), a1), null, new Quadrat(new Punkt(4711 - 666 * RND.nextDouble(), 4711 - 666 * RND.nextDouble()), a3)};
		double actualArea = ViereckKonvex.flaecheninhalt(vs[0]);
		assertEquals("ViereckKonvex.flaecheninhalt(null) failed.", 0, actualArea, PRECISION);
		assertEquals("ViereckKonvex.flaecheninhalt(einQuadrat) failed.", a1 * a1, ViereckKonvex.flaecheninhalt(vs[1]), PRECISION);
		assertEquals("ViereckKonvex.flaecheninhalt(einQuadrat, null) failed.", a1 * a1, ViereckKonvex.flaecheninhalt(vs[1], vs[2]), PRECISION);
		assertEquals("ViereckKonvex.flaecheninhalt(einQuadrat, null, einQuadrat) failed.", a1 * a1 + a3 * a3, ViereckKonvex.flaecheninhalt(vs[1], vs[2], vs[3]), PRECISION);
		assertEquals("ViereckKonvex.flaecheninhalt(array) failed.", a1 * a1 + a3 * a3, ViereckKonvex.flaecheninhalt(vs), PRECISION);
		// ----------
		assertEquals("ViereckKonvex.flaecheninhalt(null) failed.", 0, ViereckKonvex.flaecheninhalt((Viereck) null), PRECISION);
		assertEquals("ViereckKonvex.flaecheninhalt(null) failed.", 0, ViereckKonvex.flaecheninhalt((Viereck[]) null), PRECISION);
	}

	// -------------------- ViereckKonvex.filter --------------------
	@Test(timeout = 1000)
	public void pubTest__ViereckKonvex__Viereck_filter() {
		Punkt[] pX = {new Punkt(2, 1), new Punkt(5, 0), new Punkt(6, 4), new Punkt(1, 3)};
		Viereck[] vs = new ViereckKonvex[42];
		for (int i = 1; i < vs.length; i++) {
			vs[i] = new ViereckKonvex(pX[0], pX[1], pX[2], pX[3]) {
				@Override
				public double umfang() {
					return 42;
				}

				@Override
				public double flaecheninhalt() {
					return 666;
				}
			};
		}
		// ----------
		Trapez[] actual0 = ViereckKonvex.filter(vs[0]);
		assertNotNull("ViereckKonvex.filter(null) failed.", actual0);
		assertEquals("ViereckKonvex.filter(null) failed.", 0, actual0.length);
		// ----------
		Trapez[] actual1 = ViereckKonvex.filter(vs[1]);
		assertNotNull("ViereckKonvex.filter(einViereck) failed.", actual1);
		assertEquals("ViereckKonvex.filter(einViereck) failed.", 0, actual1.length);
		// ----------
		Trapez[] actual2 = ViereckKonvex.filter(vs[1], vs[0]);
		assertNotNull("ViereckKonvex.filter(einViereck, null) failed.", actual2);
		assertEquals("ViereckKonvex.filter(einViereck, null) failed.", 0, actual2.length);
		// ----------
		Trapez[] actualArray = ViereckKonvex.filter(vs);
		assertNotNull("ViereckKonvex.filter(array) failed.", actualArray);
		assertEquals("ViereckKonvex.filter(array) failed.", 0, actualArray.length);
		// ----------
		assertNotNull("ViereckKonvex.filter(null) failed.", ViereckKonvex.filter((Viereck) null));
		assertEquals("ViereckKonvex.filter(null) failed.", 0, ViereckKonvex.filter((Viereck) null).length);
		assertNotNull("ViereckKonvex.filter(null) failed.", ViereckKonvex.filter((Viereck[]) null));
		assertEquals("ViereckKonvex.filter(null) failed.", 0, ViereckKonvex.filter((Viereck[]) null).length);
		// --------------------
		final double pPx = 4711 - 666 * RND.nextDouble(), pPy = 4711 - 666 * RND.nextDouble();
		final double a = 4711.666, b = 666.4711, c = 42.42, e1 = 17.4, e2 = 20.15, e = 123.456789, f = 987.654321, h = 42.0815, alpha = 21.333;
		final Punkt pP = new Punkt(pPx, pPy);
		List<Viereck> trapezeRein = new ArrayList<>(), zeugRein;
		for (int i = 0; i < 42; i++) {
			trapezeRein.add(new Trapez(pP, a, c, h));
			trapezeRein.add(new Rechteck(pP, a, b));
			trapezeRein.add(new Quadrat(pP, a));
		}
		zeugRein = new ArrayList<>(trapezeRein);
		for (int i = 0; i < 666; i++) {
			zeugRein.add(new Drachenviereck(pP, e1, e2, f));
			zeugRein.add(new Raute(pP, e, f));
			zeugRein.add(new Parallelogramm(pP, a, h, alpha));
		}
		Collections.shuffle(zeugRein);
		Trapez[] trapezeRausFeld = ViereckKonvex.filter(zeugRein.toArray(new Viereck[0]));
		assertNotNull("ViereckKonvex.filter failed (returned null unexpectedly).", trapezeRausFeld);
		List<Viereck> trapezeRaus = Arrays.<Viereck>asList(trapezeRausFeld);
		assertEquals("ViereckKonvex.filter failed (at number of returned objects).", trapezeRein.size(), trapezeRaus.size());
		for (Viereck t : trapezeRein) {
			assertTrue("ViereckKonvex.filter failed (lost expected object).", trapezeRaus.contains(t));
		}
		for (Viereck t : trapezeRaus) {
			assertTrue("ViereckKonvex.filter failed (kept unexpected object).", trapezeRein.contains(t));
		}
	}

	// -------------------- SMOKE TEST FOR THE REST --------------------
	@Test(timeout = 1000)
	public void pubTest__smokeTestForTheRest() {
		Punkt pP = new Punkt(47, 11);
		double a = 42.0815, c = 12.345, e1 = 47.0815, e2 = 11.0815, f = 47.11, h = 666.0815, b = 0.815, alpha = 45.0815;
		ViereckKonvex drachenviereck = new Drachenviereck(pP, e1, e2, f);
		assertEquals("Drachenviereck.umfang failed.", 157.3531322559897, drachenviereck.umfang(), PRECISION);
		ViereckKonvex parallelogramm = new Parallelogramm(pP, a, h, alpha);
		assertEquals("Parallelogramm.umfang failed.", 1965.4518592328482, parallelogramm.umfang(), PRECISION);
		ViereckKonvex trapez = new Trapez(pP, a, c, h);
		assertEquals("Trapez.umfang failed.", 1386.921347270056, trapez.umfang(), PRECISION);
		Drachenviereck raute = new Raute(pP, a, h);
		assertEquals("Raute.flaecheninhalt failed.", (a * h) / 2, raute.flaecheninhalt(), PRECISION);
		Trapez rechteck = new Rechteck(pP, a, b);
		assertEquals("Rechteck.flaecheninhalt failed.", a * b, rechteck.flaecheninhalt(), PRECISION);
		Rechteck quadrat = new Quadrat(pP, a);
		assertEquals("Quadrat.flaecheninhalt failed.", a * a, quadrat.flaecheninhalt(), PRECISION);
	}

	// ========== HELPER: Intestines ==========
	// @AuD-STUDENT: DO NOT USE REFLECTION IN YOUR OWN SUBMISSION!
	private static Class<?>[] getDeclaredClasses(Class<?> clazz) {
		java.util.List<Class<?>> declaredClasses = new java.util.ArrayList<>();
		for (Class<?> c : clazz.getDeclaredClasses()) {
			if (!c.isSynthetic()) {
				declaredClasses.add(c);
			}
		}
		return declaredClasses.toArray(new Class[0]);
	}

	private static Field[] getDeclaredFields(Class<?> clazz) {
		java.util.List<Field> declaredFields = new java.util.ArrayList<>();
		for (Field f : clazz.getDeclaredFields()) {
			if (!f.isSynthetic()) {
				declaredFields.add(f);
			}
		}
		return declaredFields.toArray(new Field[0]);
	}

	private static Constructor<?>[] getDeclaredConstructors(Class<?> clazz) {
		java.util.List<Constructor<?>> declaredConstructors = new java.util.ArrayList<>();
		for (Constructor<?> c : clazz.getDeclaredConstructors()) {
			if (!c.isSynthetic()) {
				declaredConstructors.add(c);
			}
		}
		return declaredConstructors.toArray(new Constructor[0]);
	}

	private static Method[] getDeclaredMethods(Class<?> clazz) {
		java.util.List<Method> declaredMethods = new java.util.ArrayList<>();
		for (Method m : clazz.getDeclaredMethods()) {
			if (!m.isBridge() && !m.isSynthetic()) {
				declaredMethods.add(m);
			}
		}
		return declaredMethods.toArray(new Method[0]);
	}
}