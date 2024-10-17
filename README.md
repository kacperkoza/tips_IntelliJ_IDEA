### JetBrains IDE - beyond the shift-shit
#### JUGtoberfest Poznań, 16.10.2024

Feedback form - https://forms.gle/SRinxkqQ7nhjadeK7

## Legend


`⌘` - command  
`⌥` - option / ALT  
`⌃` - control / CTRL  
`⇧` - shift  
`↑` - up arrow  
`↓` - down arrow  
`→` - right arrow  
`←` - left arrow  
`⏎` - ENTER / RETURN  
`⌫` - backspace  
`LMB` - left mouse button

## 0. Introduction

## 1. Before we start

- `Theme: dark/light`
- `Keymap > Based on the macOS keymap`
- `CMD , > Presentation Assistant`  
**All shortcuts are in README.md.**
- `Font > Size > 15`  
  Additionally: [X] - `Enable ligatures`
- `Resolution - Scaled (1600x900)` for presentation purposes

## 2. Basic Navigation

`⌘ O` - `Go to class` - with exact line - `StringUtils:1500`.

`⌘ ⇧ O` - `Go to file`

`⌘ ⌥ O` - `Go to symbol`.  
Filter with namespace - `String.contains`

`⌘ ⇧ A` - `Find action` - Find any action that you can use in IDE.  
Find Action `Set Background Image`  

`⌘ ⌥ ⇧ E` - `Navigate > Text`

`⌘ ⇧ \` - `Go to endpoint`

`⇧ ⇧` - `Search Everywhere`

`⌥ ↑ OR ↓` - browse search history (in windoes above)

`⇧ ⇧` -> `2`+2*2

## 3. Switching between windows

`⌘ ⇧ F12` - `Hide All Windows` / `Restore All Windows`

`Enter Distraction Free Mode`

`⌘ E` - `Recent files`

You can filter the result list by typing some text.

Find action `Select File in Project View` and assign new shortcut with `⌥ ⏎`.

`⌘ ⇧ E` - `Recent Locations`

`⌘ 1` - `Project`  
`⌘ 4` - `Run`  
`⌘ 5` - `Debug`

Use `ESCAPE` to go back from any tool window to editor.

`⌃ ⌥ ← / →` - `Stretch (tool window) to Left / Right`

`⌘ ⇧ '` - `Maximixe Tool Window`

Use it to adjust width and height of any other tool window, for example `Recent Files`.

## 4. Assign new shortcut

Assign shortcut to any tool window from `Recent Files`.

`⌘ ⇧ A` - find `Gradle` and assign new shortcut with `⌥ ⏎`.

`⌘ ,` - `Keymap`

Click `⌘ ⇧ A` twice, to show disabled actions. It depends on the context, for example `Select File in Project View`
is not available from the `Gradle` tab.

Many shortcuts may have different meanings, depending on the context. For example, in `.md` files `⌘ B` is `Bold`.

`⌃ ⌃` - Run Anything (Gradle, AppRunner, any configuration)

## 5. Tabs vs no tabs

`⌘ ,` - `Editor tabs` - `Change to 'none'`

When tabs our enabled, check available actions for tabs.
For example, you can assign `⌘ ⇧ W` for `Close other tabs`.

`⌘ ⇧ [ / ]` - Select Previous/Next Tab

## 6. Scratch file

### a. New Scratch file

`⌘ ⇧ N` - `Scratch file`

Copy `curl.txt` and paste into `.http` scratch. Edit and then export as new cURL.

Scratch files are not detected by git. You can always create `.http` file in your project directory and keep it in git.

### b. Bookmarks

Find and use tools what you need, for example Bookmarks.

`⌘ ⇧ E` > `Bookmarks` (`⌘ 2`)

`F3` - `Toggle Bookmark`

`⌃ ⇧ 1/2/3/...` - `Toggle Bookmark 1/2/3/...`

`⌃ 1/2/3/...` - `Go to bookmark 1/2/3/...`

## 7. Navigating inside file

### a. File Structure, Next Highlighted Error, Go to Line

`⌘ F12` - `File Structure`  
`⌘ L` - `Go to Line:Column`  
`F2` - `Next Highlighted Error`
`⌘ F2` - `Previous Highlighted Error`

### b. Next Highlighted Usage

`⌘ B` - `Go to declaration or usages`

`⌘ ⌥  B` - `Go to Implementation`

`⌘ ⌥ F7` - `Show usages`

`⌥ F7` - `Find usages`

`⌘ ⌥ F7` - `Highlight usages in file `

`⌃ ⌥ ↑/↓` - `Next Highlighted Usage` - use inside the file instead of `Go to declaration` or `Find Usages`

### c. Next / previous method

`⌃ ⇧ ↑` - `Previous Method`  
`⌃ ⇧ ↓` - `Next Method`

### d. Last Edit Location

`⌘ ⌥ ← / →` OR `⌘ ] / [` `Nagivate > Back / Forward`  
`⌘ ⇧ ⌫` - `Navigate > Last Edit Location`

### e. Annotate

`Find Action` - `Git | Current File: Annotate with Git Blame`

Assign shortcut, if you use it frequently

## 8. Editing a file

`StringUtils:1500`

### a. Expand / collapse comments, folding

`⌘ ⇧ A` - Type 'collapse' and choose `Collapse Doc Comments`

`⌘ +/-` - `Folding > Expand`
`⌘ ⇧ +/-` - `Folding > Expand All`

### b. Extend selection. Duplicating, deleting lines, Paste from history

`⌘ ↑` - `Extend selection`  
`⌘ ↓` - `Shrink selection`.

`⌘ ⇧ V` - `Paste from history`

`⌘ D` - `Duplicate Line`  
`⌘ ⌫` - `Delete Line`

`⌘ /` - `Comment with Line Comment`  
`⌘ ⌥ /` - `Comment with Line Comment`

### c. Moving lines, statements

`⌘ ⇧ ↓ OR ↑` - `Move Statement Up / Down`

`⌥ ⇧ ↓ OR ↑` - `Move Line Up / Down`

### d. Multi-line cursor, select all occurrences

`⌃ G` - `Add Selection for Next Occurrence`  
`⌃ ⇧ G` - `Unselect Occurrence`

`⌃ ⌘ G` - `Select All Occurrences`

`⌥ SIFT + LMB` - Add cursor in clicked place`

`⌥ + ⌥ + ↓ / ↑` - `Clone Caret Below / Above`

### e. Run, Debug

`⌘ ⇧ R` - `Run` - runs single test or whole test class, depends on where you put the caret

`⌘ R` - `Run` - Runs last configuration (see right top corner or even better - find action `Edit configuration`)

`⌘ ⇧ D` - `Debug` - depends on where you put the caret

`⌘ D` - `Debug` - run `Debug` from the last configuration

`View breakpoints` - by holding `⌥` select or deselect breakpoint options

Check the other shortcuts for debugging, like `Evaluate Expression`, `Toggle Breakpoint` etc.

Use `⌘ ⇧ T` for creating test classes and navigating between them and source code class (`Go to test`)

### f. Replace (in Files)

`⌘ R` - `Replace`  
`⌘ ⇧ R` - `Replace in Files`

Use it in `Project` view, to run optimizer on a whole directory:  
`⌘ ⌥ L` - `Reformat Code`  
`⌘ ⌥ I` - `Auto-Indent Lines`  
`⌃ ⌥ O` - `Optimize Imports`

### g. Live templates, Surround with, Complete current Statement

`⌃ SPACE` - Basic Code Completion
It conflicts with macOS shortcut: `Input sources` > `Select previous input source`

`spgwt` - `Spock: given - when - then`

`ifn` - `if not null (Live template)`

`offerId.nn` - `Postfix completion`

`⌘ ⌥ T` - `Surround With`

`⌘ ⇧ ⏎` - `Complete Current Statement`

## 9. Refactoring

`⌘ F6` - `Change Signature`

`F6` - `Move class/file`

`⌃ T` - `Refactor This` and choose what you need

- `⌘ ⌥ M` - `Extract Method`
- `⌘ ⌥ C` - `Extract Constant` (twice for more options => hold ⌥ and press highlighted characters on keyboard)
- `⌘ ⌥ V` - `Extract Variable`
- `⌘ ⌥ N` - `Inline`

`⌘ ⌥ ⇧ K` - `Convert Java File to Kotlin File`

More refactor tools is in `Refactor` menu. **Check difference between Java and Kotlin options.**

## 10. Copilot

`Copilot: Enable completions`

a. start suggesting, for example `if` statement
```java
if (accountId != null) {
// Copilot: accountId is not null
}
```

- `Open GitHub Copilot Chat Inline Chat` and type "check account id for null or empty and throw appropriate exception"  
- ask for creating a new exception  
- ask for anything else

b. ask for preparing `curl` request

- `Open GitHub Copilot Chat Inline Chat` and type "Write curl request for this endpoint"

c. ask for method refactoring, for example `OffersService.getOffersPaginated(...)`

## 11. Additionally

- `Search Structurally` / `Replace structurally`
- `Help > Search`
- `Help > Keymap Shortcuts PDF`
- `Help > IntelliJ IDEA on YouTube`
- `Help > My Productivity`
- `Help > Change memory settings`

## Resources

https://blog.jetbrains.com/idea/category/tips-tricks/

https://www.youtube.com/user/intellijideavideo

https://blog.jetbrains.com/kotlin/2021/06/simple-steps-for-improving-your-ide-performance/

https://blog.jetbrains.com/idea/2021/08/10-places-you-don-t-need-to-use-the-mouse-in-intellij-idea

https://blog.jetbrains.com/idea/2022/10/top-underrated-shortcuts/

http://courses.ics.hawaii.edu/ics314s17/morea/development-environments/reading-intellij-macos-configuration.html

https://itectec.com/askdifferent/macos-how-to-disable-the-minimize-command-m-shortcut-in-mavericks

https://www.youtube.com/watch?v=NUndgK7f1_Q

Plugins:
- Key Promoter X (annoying, in my opinion)
