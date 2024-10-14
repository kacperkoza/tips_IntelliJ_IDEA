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
- `Keymap > Based on the macOS keymap`
- `CMD , > Presentation Assistant`
- `Font > Size > 15`  
Additionally: [X] - `Enable ligatures`
- `Resolution - Scaled (1600x900)` for presentation purposes

## 2. Basic Navigation
 
`⌘ O` - `Go to class` - with exact line - `StringUtils:1500`  
`⌘ ⇧ O` - `Go to file`  
`⌘ ⌥ O` - `Go to symbol` - Filter with namespace - `String.contains`
`⌘ ⇧ A` - `Find action` - Find any action that you can use in IDE
`⌘ ⇧ \` - `Go to endpoint`
`⌘ ⌥ ⇧ E` - `Navigate > Text`
`⇧ ⇧` - `Search Everywhere`

`⌥ ↑ OR ↓` - (in above windows) browse search history

`⇧ ⇧` -> 2+2*2

## 3. Switching between windows

`⌘ ⇧ F12` - `Hide All Windows` / `Restore All Windows`

`Enter Distraction Free Mode`

`⌘ ⇧ 1` - `Select File in Project View`

`⌘ E` - `Recent files`  

You can filter the result list by typing some text.

`⌘ ⇧ E` - `Recent Locations`

`⌘ 1` - `Project`   
`⌘ 4` - `Run`  
`⌘ 5` - `Debug`

Use `ESCAPE` to go back from tool window to editor.

`⌃ ⌥ ← / →` - `Stretch (tool window) to Left / Right`

Use it to adjust width and height of any other tool window, for example `Recent Files`

Assign shortcut to any tool window from `Recent Files` (find it via `⌘ A`).

## 4. Assign new shortcut

`⌘ ⇧ A` - find `Gradle` and assign new shortcut with `⌥ ⏎`

`⌘ ,` - `Keymap`

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

## 7. Navigating inside file

### a. File Structure, Next Highlighted Error, Go to Line

`⌘ F12` - `File Structure`  
`⌘ L` - `Go to Line:Column`  
`F2` - `Next Highlighted Error`
`⌘ F2` - `Previous Highlighted Error`

### b. Next Highlighted Usage

`⌘ B` - `Go to declaration or usages`

Many shortcuts may have different meanings, depending on the context. For example, in `.md` files `⌘ B` is `Bold`.

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

`⌥ + ⌥ + ↓ / ↑` - `Clone Caret Below / Above`

`⌃ G` - `Add Selection for Next Occurrence`  
`⌃ ⇧ G` - `Unselect Occurrence`  

`⌃ ⌘ G` - `Select All Occurrences`

`⌥ SIFT + LMB` - Add cursor in clicked place`

### e. Replace (in Files)

`⌘ R` - `Replace`  
`⌘ ⇧ R` - `Replace in Files`

Use it in `Project` view, to run optimizer on a whole directory:  
`⌘ ⌥ L` - `Reformat Code`  
`⌘ ⌥ I` - `Auto-Indent Lines`  
`⌃ ⌥ O` - `Optimize Imports`

### h. Live templates, Surround with, Complete current Statement

`⌃ SPACE` - Basic Code Completion 
It conflicts with macOS shortcut: `Input sources` > `Select previous input source`

`spgwt` - `Spock: given - when - then`

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

More refactor tools is in `Refactor` menu. **Check difference between Java and Kotlin options.**

## 10. Copilot

## 11. Additionally

- `Search Structurally`
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

Plugins:
- Key Promoter X (annoying, in my opinion)
