# Image Placeholder URL Generator

This is a NetBeans plugin. Generate a placeholder URL for specified size.

## Usage

- Right-click on an editor(html or php)
- Generate Image Placeholder
- Input values
- Click `Insert img tag` or `Copy`

### Load default

Load default values for specified placeholder.

### Save as default

Save current placeholder's values as default. (NOTE: alt and title values are not saved)

### Update preview

If you don't click this button, it's not updated.

### Insert img tag

Insert an img tag to a caret position of the current focused editor. alt ant title values are used with this feature.
If alt is empty, service name is used as a value.
e.g.

```html
<img src="http://lorempixel.com/600/480" alt="lorempixel" title="something" />
```

### Copy

Copy URL to clipboard. (NOT an img tag)


## Supported services

- [lorempixel](http://lorempixel.com/)
- [placekitten](https://placekitten.com/)

## Download

https://github.com/junichi11/netbeans-image-placeholder/releases

## License

The MIT license

Copyright (c) 2015 junichi11

Permission is hereby granted, free of charge, to any person
obtaining a copy of this software and associated documentation
files (the "Software"), to deal in the Software without
restriction, including without limitation the rights to use,
copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the
Software is furnished to do so, subject to the following
conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
OTHER DEALINGS IN THE SOFTWARE.
