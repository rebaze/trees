package dogtooth.tree;

import dogtooth.tree.util.StreamTreeBuilder;
import dogtooth.tree.util.TreeConsoleFormatter;
import dogtooth.tree.util.TreeTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

import static dogtooth.tree.Selector.selector;

public class FSTreeTest {
    private final static Logger LOG = LoggerFactory.getLogger(FSTreeTest.class);

    private final TreeTools TOOLS = new TreeTools();
    private final TreeConsoleFormatter FORMAT = new TreeConsoleFormatter();

    private void collect( TreeBuilder builder, File base ) {
        for (File f: base.listFiles() ) {
            if (f.isHidden()) continue;
            TreeBuilder sub = builder.branch( selector(f.getName()) );
            if (f.isDirectory()) collect(sub,f);else {
                new StreamTreeBuilder( sub ).add(f);
            }
       }
    }
}