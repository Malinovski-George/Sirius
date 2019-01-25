package by.malinovski.book.controller;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {


  @RequestMapping(value = "/getCache", method = RequestMethod.GET)
  public String dumpKeys() {
    String regions[] = CacheManager.getInstance().getCacheNames();
    StringBuilder allkeys = new StringBuilder();
    String newLine = System.getProperty("line.separator");
    for (String region : regions) {
      Ehcache cache = CacheManager.getInstance().getEhcache(region);
      allkeys.append(cache.getKeys());
      allkeys.append(newLine);
    }
    return allkeys.toString();
  }

  @RequestMapping(value = "/claerCache", method = RequestMethod.GET)
  public void clearCache() {
    CacheManager.getInstance().clearAll();
  }
}
