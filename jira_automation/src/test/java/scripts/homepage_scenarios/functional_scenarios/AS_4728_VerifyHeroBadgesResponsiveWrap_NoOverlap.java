package scripts.homepage_scenarios.functional_scenarios;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic.OpenClose;
import generic.ScreenshotUtility;
import pom.HomePage;

public class AS_4728_VerifyHeroBadgesResponsiveWrap_NoOverlap extends OpenClose {

	@DataProvider(name = "viewports")
	public Object[][] viewports() {
		return new Object[][] {
				// Mobiles
				{ 320, 568, "iPhone SE (320x568)" }, { 360, 800, "Android Small (360x800)" },
				{ 390, 844, "iPhone 12/13/14 (390x844)" }, { 412, 915, "Pixel (412x915)" },

				// Tablets
//				{ 768, 1024, "iPad (768x1024)" }, { 820, 1180, "iPad Air (820x1180)" }
		};
	}

	@Test(dataProvider = "viewports")
	public void testBadgesWrap_NoOverlap(int w, int h, String label) throws InterruptedException {

		setViewport(w, h);
		Thread.sleep(800);

		HomePage page = new HomePage(driver);
		ScreenshotUtility su = new ScreenshotUtility(driver);

		try {
			WebElement container = page.getBadgeContainer();
			List<WebElement> badges = page.getAllBadges();

			Assert.assertNotNull(container, "Badge container is NULL for: " + label);
			Assert.assertTrue(container.isDisplayed(), "Badge container is NOT displayed for: " + label);

			Assert.assertNotNull(badges, "Badge list is NULL for: " + label);
			Assert.assertTrue(badges.size() == 4, "Expected 4 badges, found " + badges.size() + " for: " + label);

			Rectangle containerRect = container.getRect();
			List<Rectangle> rects = new ArrayList<>();

			for (int i = 0; i < badges.size(); i++) {
				WebElement b = badges.get(i);
				Assert.assertTrue(b.isDisplayed(), "Badge #" + (i + 1) + " not displayed for: " + label);

				Rectangle r = b.getRect();

				Assert.assertTrue(r.getWidth() > 0 && r.getHeight() > 0,
						"Badge #" + (i + 1) + " has invalid size " + r + " for: " + label);

				int tol = 2;
				Assert.assertTrue(r.getX() >= containerRect.getX() - tol,
						"Badge #" + (i + 1) + " overflow LEFT for: " + label);
				Assert.assertTrue((r.getX() + r.getWidth()) <= (containerRect.getX() + containerRect.getWidth() + tol),
						"Badge #" + (i + 1) + " overflow RIGHT for: " + label);

				Assert.assertTrue(r.getY() >= containerRect.getY() - tol,
						"Badge #" + (i + 1) + " overflow TOP for: " + label);
				Assert.assertTrue(
						(r.getY() + r.getHeight()) <= (containerRect.getY() + containerRect.getHeight() + tol),
						"Badge #" + (i + 1) + " overflow BOTTOM for: " + label);

				rects.add(r);
			}

			for (int i = 0; i < rects.size(); i++) {
				for (int j = i + 1; j < rects.size(); j++) {
					boolean overlap = intersects(rects.get(i), rects.get(j));
					Assert.assertFalse(overlap, "Badges overlap detected between badge " + (i + 1) + " and " + (j + 1)
							+ " for: " + label + " | r1=" + rects.get(i) + " r2=" + rects.get(j));
				}
			}

			if (w <= 360) {
				int rowCount = countRowsByY(rects, 3);
				Assert.assertTrue(rowCount >= 2, "Expected badges to wrap into 2+ rows on small width, but rowCount="
						+ rowCount + " for: " + label);
			}

			System.out.println("[PASS] Badge wrap + no-overlap OK for: " + label);

		} catch (AssertionError ae) {
			System.out.println("[FAIL] " + label + " -> " + ae.getMessage());
			su.captureScreenshot();
			throw ae;
		} catch (Exception e) {
			System.out.println("[ERROR] " + label + " -> " + e.getMessage());
			su.captureScreenshot();
			throw e;
		}
	}

	private boolean intersects(Rectangle a, Rectangle b) {
		int ax1 = a.getX();
		int ay1 = a.getY();
		int ax2 = a.getX() + a.getWidth();
		int ay2 = a.getY() + a.getHeight();

		int bx1 = b.getX();
		int by1 = b.getY();
		int bx2 = b.getX() + b.getWidth();
		int by2 = b.getY() + b.getHeight();

		return ax1 < bx2 && ax2 > bx1 && ay1 < by2 && ay2 > by1;
	}

	private int countRowsByY(List<Rectangle> rects, int tolerancePx) {
		Set<Integer> rows = new HashSet<>();
		for (Rectangle r : rects) {
			int y = r.getY();
			boolean matchedExisting = false;

			for (Integer existing : rows) {
				if (Math.abs(existing - y) <= tolerancePx) {
					matchedExisting = true;
					break;
				}
			}
			if (!matchedExisting) {
				rows.add(y);
			}
		}
		return rows.size();
	}
}