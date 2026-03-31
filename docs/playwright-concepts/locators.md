Here is how and when to use each locator, strictly ordered by priority.

1. getByRole()

Context: Your go-to locator for interactive elements (buttons, links, headings, checkboxes, dialogs).

DOM Scenario: <input type="checkbox" id="terms" /><label for="terms">I agree</label>

Action: await page.getByRole('checkbox', { name: 'I agree' }).check();

2. getByLabel()

Context: The primary way to locate form fields. It associates the <label> text with the corresponding <input>, <textarea>, or <select>.

DOM Scenario: ```html
Enter Password

Action: await page.getByLabel('Enter Password').fill('Secret123');

Expert Tip: If your getByLabel fails, your developers probably forgot to link the label to the input using the for and id attributes. Fixing this improves both your tests and accessibility!

3. getByPlaceholder()

Context: Use this when an input field lacks a visible label and relies solely on a placeholder.

DOM Scenario: <input type="email" placeholder="name@company.com" />

Action: await page.getByPlaceholder('name@company.com').fill('john@test.com');

4. getByText()

Context: Best for non-interactive text elements like paragraphs, spans, or alerts.

DOM Scenario: <div class="alert alert-success">Payment successful!</div>

Action: await expect(page.getByText('Payment successful!')).toBeVisible();

Expert Tip: By default, getByText is a substring match and case-insensitive. Use { exact: true } to prevent accidental matches (e.g., matching "User" when you meant to match "New User").

5. getByAltText()

Context: Exclusively used for images (<img> or SVG elements with <title>).

DOM Scenario: <img src="/avatars/user1.png" alt="Profile picture of John" />

Action: await expect(page.getByAltText('Profile picture of John')).toBeVisible();

6. getByTitle()

Context: Used when an element has a title attribute, which usually creates a native browser tooltip on hover. Often used for icon-only buttons.

DOM Scenario: <span title="Delete Document">🗑️</span>

Action: await page.getByTitle('Delete Document').click();

7. getByTestId()

Context: The Escape Hatch. Sometimes, the DOM is just too complex, text is dynamically generated, or there's no semantic role to hook into (like a complex third-party charting library). You ask developers to add a specific data-testid attribute.

DOM Scenario: <canvas data-testid="revenue-chart-canvas"></canvas>

Action: await page.getByTestId('revenue-chart-canvas').click();

Expert Tip: Playwright looks for data-testid by default. You can change this globally in your config if your team uses a different convention, like data-cy or data-automation-id.

8. page.locator()

Context: The fallback CSS/XPath engine. Use this when you absolutely must traverse complex DOM structures, find elements by CSS attributes, or use pseudo-classes that the getBy* methods can't handle.

DOM Scenario: <li class="item active" data-state="loaded">Item 3</li>

Action: await page.locator('li.item.active[data-state="loaded"]').click();

Chaining and Filtering: Tackling Complex DOMs

Often, a single locator isn't enough to uniquely identify an element. This is where Chaining and Filtering come in.

Chaining

Chaining narrows down the search scope by looking inside another element. Think of it as "Find X, and inside X, find Y."

DOM Scenario: You have two identical forms (Login and Register) on the same page, both with a "Submit" button.

HTML
<form aria-label="Login Form">
  <button>Submit</button> 
</form>

<form aria-label="Registration Form">
  <button>Submit</button> 
</form>
Action:

JavaScript
// Find the specific form first, then chain to find the button inside it
const loginForm = page.getByRole('form', { name: 'Login Form' });
await loginForm.getByRole('button', { name: 'Submit' }).click();
Filtering

Filtering takes a list of matching elements and narrows them down based on a condition (usually what text or elements they contain).

DOM Scenario: A list of product cards. You want to click the "Add to Cart" button specifically for the "Laptop".

HTML
<ul role="list">
  <li role="listitem">
    <h3>Smartphone</h3>
    <button>Add to Cart</button>
  </li>
  <li role="listitem">
    <h3>Laptop</h3>
    <button>Add to Cart</button>
  </li>
</ul>
Action:

Java
// 1. Get all list items
// 2. Filter for the one containing the text 'Laptop'
// 3. Chain to find the button inside that specific list item
await page.getByRole('listitem')
.filter({ hasText: 'Laptop' })
.getByRole('button', { name: 'Add to Cart' })
.click();